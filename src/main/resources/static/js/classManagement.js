const classbatchInforForm = $(".classbatch-infor-form");

if (classbatchInforForm) {
    const newBudgetItem = `<tr class="content-item">
        <td>
            <button type="button" class="content-table-remove-btn remove-budget-btn" onclick="removeTableItem(this)">
                <i class="fa-solid fa-trash-can"></i>
            </button>
        </td>
        <td>
            <input type="text" name="" id="">
        </td>
        <td>
            <input type="text" name="" id="">
        </td>
        <td>
            <input type="text" name="" id="">
        </td>
        <td>
            <input type="text" name="" id="">
        </td>
        <td>
            <input type="text" name="" id="">
        </td>
        <td>
            <input type="text" name="" id="">
        </td>
        <td>
            <input type="text" name="" id="">
        </td>
        <td>
            <input type="text" name="" id="">
        </td>
        </tr>`
    const newAuditItem = `<tr class="content-item">
        <td>
            <button type="button" class="content-table-remove-btn remove-audit-btn" onclick="removeTableItem(this)">
                <i class="fa-solid fa-trash-can"></i>
            </button>
        </td>
        <td class="col-7">
            <input type="date" name="" id="">
        </td>
        <td class="col-7">
            <select value="">
                <option name="" id=""></option>
            </select>
        </td>
        <td class="col-7">
            <input type="text" name="" id="">
        </td>
        <td class="col-7">
            <input type="text" name="" id="">
        </td>
        <td class="col-7">
            <input type="text" name="" id="">
        </td>
        <td class="col-7">
            <input type="date" name="" id="">
        </td>
        <td class="col-7">
            <input type="text" name="" id="">
        </td>
    </tr>`

    const addBudgetBtn = classbatchInforForm.find(".class-budget .add-budget-btn");
    const addAuditBtn = classbatchInforForm.find(".class-audit .add-audit-btn");

    addBudgetBtn.click((e) => {
        e.preventDefault();
        addTableItem(e.currentTarget, newBudgetItem);
    });

    addAuditBtn.click((e) => {
        e.preventDefault();
        addTableItem(e.currentTarget, newAuditItem);
    });
}

function addTableItem(btn, item) {
    const table = $(btn).parents('table');
    table.append(item);
}

function removeTableItem(btn) {
    const table = $(btn).parents('table');
    const tableItems = table.find('.content-item');
    const tableItem = $(btn).parents('.content-item');
    console.log(tableItem);

    if (tableItems.length == 1) {
        table.find('input').val('');
        return;
    }
    
    tableItem.remove();
}