const CLASS_API = '/classes';

const classbatchInforForm = $(".classbatch-infor-form");
const modal = $(".modal");

const message = {
    msg1: "Do you want to discard the changes ?",
    msg2: "You have to finish creating class first."
}

const confirmModal = (message) => `
    <div th:fragment="modal" class="modal-dialog modal-dialog-centered">
        <div class="modal-content border-dark rounded-0">
            <div class="modal-header py-1 border-dark">
                <h5 class="modal-title font-weight-normal text-body" id="exampleModalLabel" style="font-size: 18px;">Confirm</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-center">
                <div class="d-flex justify-content-center align-top">
                    <i class="fa-solid fa-circle-info text-success mr-2" style="font-size: 22px;"></i>
                    <span>${message}</span>
                </div>
                <div class="pt-2">
                    <button type="button" class="btn bg-light border border-dark rounded-0 confirm-btn" style="width: 75px;">OK</button>
                    <button type="button" class="btn bg-light border border-dark rounded-0 ml-3" data-dismiss="modal" style="width: 75px;">Cancel</button>
                </div>
            </div>
            <div class="modal-footer py-3 border-dark"></div>
        </div>
    </div>
`

const warningModal = (message) => `
    <div th:fragment="modal" class="modal-dialog modal-dialog-centered">
        <div class="modal-content border-dark rounded-0">
            <div class="modal-header py-1 border-light">
                <h5 class="modal-title font-weight-normal text-body" id="exampleModalLabel" style="font-size: 18px;">Message</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-center">
                <div class="d-flex justify-content-center align-top">
                    <i class="fa-solid fa-circle-exclamation text-warning mr-2" style="font-size: 22px;"></i>
                    <span>${message}</span>
                </div>
            </div>
            <div class="modal-footer py-3 border-light">                 
            </div>
        </div>
    </div>
`

$(document).ready(e => {
	
	initInforTab();

    // Submit form
    classbatchInforForm.submit(e => {
        e.preventDefault();
        let action = e.target.dataset?.action.toLowerCase();
        let classId = e.target.dataset?.classId;
        let url = (action == 'create' ? `${CLASS_API}/${action}` : `${CLASS_API}/${action}/${classId}`);
        submitClassBatch(classbatchInforForm, url, {success: (data) => {
            showModal({
                html: data,
                confirm: (modal) => {
                    submitClassBatch(classbatchInforForm, url, { confirm: 'true', success: (data) => {
                        showModal({
                            html: data,
                            backdrop: "static"
                        })
                    }})
                }
            })
        }});
    })

    // Handle add or remove row from budget and audit table
    addOrRemoveTableRow({ table: ".budget-table"});
    addOrRemoveTableRow({ table: ".audit-table"});
    
    // Clear modal content when modal hide
    modal.on('hidden.bs.modal', (e) => {
        resetModal($(e.target))
    })

    // Handle switch tab
    $(".nav-tabs .nav-link").click(changeTab);
})

function submitClassBatch(form, url, {confirm = 'false', success = () => {}}) {
    const formData = new FormData($(form)[0]);
    if (confirm === 'true') {
        url = url + "?confirm=true";
    }
    $.ajax({
        url: url,
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        method: 'POST',
        type: 'POST',
        success: success,
    });
}

function changeClassState(action, classId, {confirm = 'false', method = 'GET', success = () => {}}) {
    const data = {
		classId: classId
	};
    if (confirm === 'true') {
        data.confirm = confirm;
    }
    $.ajax({
        url: CLASS_API + `/${action}`,
        data: data,
        dataType: "html",
        processData: true,
        cache: true,
        method: method,
        success: success,
    });
}

function changeTab(e) {
	e.preventDefault();
    if (!$(e.target).hasClass("active")) {
        const requestPram = window.location.search;
        const params = new URLSearchParams(requestPram);
        const path = e.target.dataset.path;
        const url = `${CLASS_API}/${path}`;
        let requestParam = {
            classId: params.get("classId")
        }
        const sendAjax = (agmts = {}) => {
            $.ajax({
                method: "GET",
                url: url,
                data: requestParam,
                success: (data) => {
                    const html = $(data);
                    const modalContent = html.find(".modal").html().trim();

                    $(".tab-pane").html(html.find(".tab-pane").html());
                    if (modalContent) {
                         showModal({html: modalContent, timeOut: 10000});
                    } 
                    else if (agmts.modal) {
                        agmts.modal.modal('hide');
                    } 

                    $(e.target).parents(".nav-tabs").find(".nav-link").removeClass("active");
                    $(e.target).addClass("active");
                    history.pushState({}, null, `${url}?${$.param(requestParam)}`);
                    initInforTab();
                }
            })
        }

        if (path == 'trainees' && window.location.pathname == `${CLASS_API}/create`) {
            showModal({
                html: warningModal(message.msg2),
                timeOut: 4000
            })
        } else if (path == 'trainees' && window.location.pathname == `${CLASS_API}/update`) {
            showModal({
                html: confirmModal(message.msg1),
                confirm: (modal) => {
                    sendAjax({modal});
                }
            })
        }
        else if (!requestParam.classId) {
            window.location.href = `${CLASS_API}`;
        }
        else {
            sendAjax();
        }
    }
}

function initInforTab() {
	handleReadonlyInput();
	
	// Show selected file name at custom input file
    $('.custom-file').find('.custom-file-input').change(e => {
        e.stopPropagation();
        $(e.target).next('.custom-file-label').text(e.target.files?.[0]?.name || "")
    })

    // Set td background when input is readonly
    $("input").each((index, item) => {
        if (item.readOnly == true) {
            $(item).parents('td').css('background-color', 'var(--light-gray)');
        }
    })
    $(".content-table").find(".readonly").parents('td').css('background-color', 'var(--light-gray)');

    // Handle colapse section
    $(".form-content-section").find(".collapse-btn").click(e => {
        e.stopPropagation();
        $(e.currentTarget).parents('.form-content-section').find('.section-content').slideToggle();
    })

    // Handle action button
    $(".classbatch-infor-form").find(".control-btn button:not([type='submit'])").click(e => {
        e.stopPropagation();
        let action = e.target.dataset?.action.toLowerCase();
        let classId = $(".classbatch-infor-form").data('classId');
        if (action && classId) {
            if (action == 'update') {
                window.location.href = CLASS_API + `/${action}?classId=${classId}`;
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

    // Handle update curriculumn file
    $("#curriculumn-file").change(e => {
        $(".curriculumn-update-state").val(Date.now());
        $(".curriculumn-download").remove();
    })
}



