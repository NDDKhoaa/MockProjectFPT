const CLASS_API = '/classes';

const classbatchInforForm = $(".classbatch-infor-form");
const modal = $(".modal");

$(document).ready(e => {

    // Submit form
    classbatchInforForm.submit(e => {
        e.preventDefault();
        let action = e.target.dataset?.action.toLowerCase();
        let classId = e.target.dataset?.classId;
        let url = action == 'create' ? (CLASS_API + `/${action}`) : (CLASS_API + `/${action}/${classId}`);
        submitClassBatch(classbatchInforForm, url, {success: (data) => {
            showModal({
                html: data,
            })
            modal.find('.confirm-btn').click(e => {
                submitClassBatch(classbatchInforForm, url, { confirm: 'true', success: (data) => {
                    showModal({
                        html: data,
                        backdrop: "static"
                    })
                }})
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
                window.location.href = CLASS_API + `/${action}/${classId}`;
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
    const data = {};
    if (confirm === 'true') {
        data.confirm = confirm;
    }
    $.ajax({
        url: CLASS_API + `/${action}/${classId}`,
        data: data,
        dataType: "html",
        processData: true,
        cache: true,
        method: method,
        success: success,
    });
}



