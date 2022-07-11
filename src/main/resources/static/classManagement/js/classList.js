const CLASS_API = "/classes"
const PRE_CONDITION = {
	Update: ['Draft', 'InProgress', 'Rejected', 'Declined'], 
	Submit: ['Draft', 'Rejected', 'Declined'], 
	Cancel: ['Draft', 'Submitted'], 
	Reject: ['Submitted'], 
	Approve: ['Submitted'], 
	Decline: ['Planning'], 
	Accept: ['Planning'], 
	Start: ['Planned'],
	Finish: ['InProgress', 'WaitingForMoreInformation'], 
	Close: ['PendingForReview'],
	Request: ['Closed']
}
const ACTIONABLE = {
	Draft: ["Update", "Submit", "Cancel"],
	Submitted: ["Cancel", "Reject", "Approve"],
	Rejected: ["Update", "Submit"],
	Cancelled: [],
	Declined: ["Update", "Submit"],
	Planning: ["Decline", "Accept", ],
	Planned: ["Start"],
	InProgress: ["Finish"],
	PendingForReview: ["Close"],
	Closed: ["Request"],
	WaitingForMoreInformation: ["Finish"],
}

const modal = $(".modal");
const classSearchResult = $(".search-result");

$(document).ready(e => {
	const searchClassForm = $(".search-class-form");
	initClassTable();
	
	searchClassForm.submit(e => {
		e.preventDefault();
		searchClass();
	})
	
	// Clear modal content when modal hide
    modal.on('hidden.bs.modal', (e) => {
        resetModal($(e.target))
    })
})

function changeClassState(action, classId, {confirm = 'false', method = 'GET', success = () => {}}) {
    const data = {
		classId: classId[0]
	};
    if (confirm === 'true') {
        data.confirm = confirm;
    }
    $.ajax({
        url: `${CLASS_API}/${action}`,
        data: data,
        dataType: "html",
        processData: true,
        cache: true,
        method: method,
        success: success,
    });
}

function disableControlBtn(actionabels) {
	$(".control-btn").find("button").each((index, btn) => {
		let btnAction = btn.dataset.action;
		if (btnAction && btnAction != "Create") {
			btn.disabled = !actionabels[btn.dataset.action];
		}
	})
}

function searchClass(pageable = {pageIndex: false}) {
	const searchClassForm = $(".search-class-form");
	if (!pageable.pageIndex) {
		pageable.pageIndex = $("select[name='pageIndex']").val();
	}
	pageable.pageSize = $("select[name='pageSize']").val();
	let data = searchClassForm.serialize() + `&${$.param(pageable)}`;
	$.ajax({
		method: "GET",
		url: CLASS_API,
		data: data,
		success: (data) => {
			let html = $(data);
			$(".search-result").html(html.find(".search-result").html());
			initClassTable();
			if (html.find(".modal").html().trim()) {
				showModal({
					html: html.find(".modal").html(),
				})					
			}
		}
	})
}

function initClassTable() {
	const actionabels = {
		Create: true,
	};
	for (let key in PRE_CONDITION) {
		actionabels[key] = false;
	}
	disableControlBtn(actionabels);

	$(".class-table").find(".check-all").change(e => {
		$("input[name='classId']").prop("checked", e.target.checked);
	})

	$(".check-class").change(e => {
		let classActionables = [];
		$(".check-class:checked").each(item => {
			if (!classActionables.length) {
				classActionables.push(...ACTIONABLE[e.target.dataset.classStatus]);
			}
			else {
				classActionables = classActionables.filter(a => {
					return ACTIONABLE[e.target.dataset.classStatus].includes(a);
				})
			}
		})
		for (let action in actionabels) {
			console.log(classActionables.includes(action));
			if (classActionables.includes(action)) {
				actionabels[action] = true;
			}
			else {
				actionabels[action] = false;
			}
		}
		disableControlBtn(actionabels);
	})

	$("select[name='pageSize'], select[name='pageIndex']").change(e => {
		e.stopPropagation();
		searchClass();
	})

	$(".pagination .page-link").click(e => {
		const pageLink = $(e.target);
		let pageIndex = $("select[name='pageIndex']").val();

		if (pageLink.parents(".page-item").hasClass("disabled")) {
			return;
		}

		if (!pageLink.parents(".page-item").hasClass("active")) {
			if (pageLink.hasClass("previous")) {
				pageIndex--;
			}
			else if (pageLink.hasClass("next")) {
				pageIndex++;
			}
			else {
				pageIndex = pageLink.text();
			}
			searchClass({pageIndex});
		}
	})

	classSearchResult.find(".control-btn button:not([type='submit'])").click(e => {
		e.stopPropagation();
		let action = e.target.dataset?.action.toLowerCase();
		let classId = [];
		$(".class-table").find("input[name='classId']:checked").each((index, item) => {
			classId.push(item.value);
		});
		
		if (action == 'create') {
				window.location.href = `${CLASS_API}/${action}`;
			}
			
		if (action && classId.length) {
			if (action == 'update') {
				window.location.href = `${CLASS_API}/${action}?classId=${classId[0]}`;
			}

			changeClassState(action, classId, {success: (data) => {
				showModal({
					html: data,
				})
				modal.find('.confirm-btn').click(e => {
					changeClassState(action, classId, { confirm: 'true', method: 'POST', success: (data) => {
						showModal({
							html: data,
							backdrop: "static"
						})
					}})
				})
			}})
		}
	})
}