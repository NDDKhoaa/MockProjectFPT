$('document').ready(e => {
    $("input[type='date']:read-only").filter('[value=""]').prop('type', 'text');
})

function showModal({modal = '.modal', html = false, timeOut = 0, backdrop = 'true'}) {
    if  (backdrop == 'static') {
        $(modal).data('bs.modal')._config.backdrop = 'static';
        $(modal).data('bs.modal')._config.keyboard = false;
    }
    !!html && $(modal).html(html);
    $(modal).modal('show');
    if (timeOut > 0) {
        setTimeout(() => {
            $(modal).modal('hide');
        }, timeOut)
    }
}
window.showModal = showModal;

function resetModal(jqModal) {
    jqModal.empty();
    jqModal.data('bs.modal')._config.backdrop = true;
    jqModal.data('bs.modal')._config.keyboard = true;
}
window.resetModal = resetModal;

function addOrRemoveTableRow({table, addBtn = ".add-row-btn", removeBtn = ".remove-row-btn", contentItem = ".content-item"}) {
    const addRowBtn = $(table).find(addBtn);
    const removeRowBtn = $(table).find(removeBtn);
    addRowBtn.click(e => {
        addTableRow(table, removeBtn, contentItem);
    })
    removeRowBtn.click(e => {
        removeTableRow($(e.target).parents(contentItem), table, contentItem);
    })
}

function addTableRow(table, removeBtn, contentItem) {
    if ($(table).length == 0) {
        return;
    }
    const newRow = $(table).find(`${contentItem}:last-child`).clone();
    newRow.find("input:not([type='radio']), select, textarea").filter(":not([type='checkbox'])").val('');
    newRow.find("input[type='radio'], input[type='checkbox']").prop("checked", false);

    let newRowIndex = newRow.find("input:first-child")[0].name?.replaceAll(/(.*\[)|(\].*)/g, "");
    newRowIndex = Number(newRowIndex);
    if (typeof newRowIndex === "number" && newRowIndex != NaN) {
        newRowIndex++;
        newRow.find("input, textarea, select").each((index, item) => {
            item.name = item?.name.replace(/\[[\d]+\]/, "[" + newRowIndex + "]");
        })
    }
    newRow.find(removeBtn).click(e => {
        removeTableRow(newRow, table, contentItem);
    })
    if ($(table).find("tbody").length == 0) {
        $(table).append(newRow);
        return;
    }
    $(table).find("tbody").append(newRow);
}

function removeTableRow(jqRow, table, contentItem) {
    if (!jqRow) {
        return;
    }
    if (jqRow.parents(table).find(contentItem).length == 1) {
        jqRow.find("input:not([type='radio']), select, textarea").filter(":not([type='checkbox'])").val('');
        jqRow.find("input[type='radio'], input[type='checkbox']").prop("checked", false);
        return;
    }
    if (!jqRow.is(jqRow.parents(table).find(`${contentItem}:last-child`))) {
        let rowIndex = $(jqRow).find("input:first-child")[0].name?.replace(/(.*\[)|(\].*)/g, "");
        if (typeof newRowIndex === "number" && newRowIndex != NaN) {
            jqRow.nextAll().each((index, item) => {
                item.name = item.name?.replace(/\[[\d]+\]/, "[" + rowIndex + "]");
                rowIndex++;
            })
        }
    }
    jqRow.remove();
}

function sendRedirect(redirect, redirectDelay) {
    setTimeout(() => {
        window.location.href = redirect;
    }, redirectDelay);
}