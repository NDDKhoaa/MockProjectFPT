const CLASS_API = "/classes"

const modal = $(".modal");
const classSearchResult = $(".search-result");

$(document).ready(e => {
	const searchClassForm = $(".search-class-form");
	
	initClassTable();
	
	searchClassForm.submit(e => {
		e.preventDefault();
		$.ajax({
			method: "GET",
			url: CLASS_API,
			data: searchClassForm.serialize(),
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
	})
	
	// Clear modal content when modal hide
    modal.on('hidden.bs.modal', (e) => {
        resetModal($(e.target))
    })
    
    function initClassTable() {
		$(".class-table").find(".check-all").change(e => {
			$("input[name='classId']").prop("checked", e.target.checked);
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
})

function changeClassState(action, classId, {confirm = 'false', method = 'GET', success = () => {}}) {
    const data = {
		classId: classId
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