const multiselect = $('.multiple-select');
const newItemHtml = `
    <div class="selected-item">
        <input type="text" hidden class="item-input">
        <label class="item-label" for=""></label>
    </div>
`
const separateHtml = `
    <span class="item-separate">,&nbsp</span>
`

if (multiselect) {
    $(document).ready(e => {

        multiselect.find('.selected-item').find("input").each(checkItemWhenInitialize)
        
        if (!multiselect.attr("readonly")) {
            multiselect.click(toggleDataSet);
            multiselect.find('.select-data').find(".data-item").find("input").change(toggleSelectedItem);
        }

        $(document).click(e => {
            multiselect.find('.select-data').hide();
        })

        function checkItemWhenInitialize(index, item) {
            const dataItemInput = $(item).parents('.multiple-select').find('.select-data').find(`input[value='${$(item).val()}']`);
            dataItemInput.prop("checked", true);
        }
    
        function toggleDataSet(e) {
            e.stopPropagation();
            $(e.currentTarget).find('.select-data').toggle();
        }

        function toggleSelectedItem(e) {
            e.stopPropagation();
            if ($(e.currentTarget).prop("checked")) {
                addSelectedItem($(e.currentTarget));
            }
            else {
                removeSelectedItem($(e.currentTarget));
            }
        }

        function addSelectedItem(item) {
            const parents = $(item).parents(".multiple-select");
            const selectedBox = parents.find(".selected-box");

            const newItem = $(newItemHtml);
            let itemIndex = selectedBox.find(".selected-item").length;

            let inputName = parents.attr("name").split(".");
            if (inputName.length > 0) {
                inputName[0] = inputName[0].replace("[]", "");
            }

            newItem.find(".item-input").prop("name", inputName[0] + `[${itemIndex}].${inputName[1] ? inputName[1] : ""}`);
            newItem.find(".item-input").val($(item).val());
            newItem.find(".item-label").text($(item).parents('.data-item').find(".data-item-label").text());
   
            parents.find(".selected-box").append(newItem);
            if (itemIndex) {
                newItem.prepend($(separateHtml));
            }
        }

        function removeSelectedItem(item) {
            const parents = $(item).parents(".multiple-select");
            let selectedInput;
            parents.find(".selected-box").find("input").each((index, i) => {
                i.value == $(item).val() ? selectedInput = $(i) : undefined;
            });
            const selectedItem = selectedInput?.parents('.selected-item');

            let itemIndex = parents.find('.selected-item').index(selectedItem);
            let inputName = parents.attr("name").split(".");
            selectedItem?.nextAll().each((index, item) => {
                $(item).find('.item-input').prop("name", inputName[0].replace("[]", "") + `[${itemIndex}].${inputName[1] ? inputName[1] : ""}`);
                if (!itemIndex) $(item).find('.item-separate')?.remove();
                itemIndex++;
            })

            selectedItem?.remove();
        }
    })
}






