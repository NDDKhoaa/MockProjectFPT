addRemoveTableRow($(".budget-table"));


function addRemoveTableRow(table) {

    const addRowBtn = table.find(".add-row-btn");
    const removeRowBtn = table.find(".remove-row-btn");

        removeRowBtn.click(e => {
            removeTableRow($(e.target).parents(".content-item"));
        })

    addRowBtn.click(e => {
        addTableRow(table);
    })

    
}

function addTableRow(table) {
    var size = table.find(".content-item").length;
    // console.log(size);
    table.find(".content-item")
     //clone last row to variable
    var row = table.find('tbody>tr:last').clone(true);
    row.prop("style", "");
     //clear text boxes
    $("td input:text", row).val("");
    $("td input[type='date']", row).val("");
    $("td input:text:last", row).val(0);
    $("select option:selected", row).attr("selected", false);

    row.insertAfter(table.find('tbody>tr:last'));
    
    var rows = table.find('.content-item');
    

    $(function(){
        var i = 0;
        rows.each(function(index1, item){
            
            var children = $(item).children();
            var inputs = $(children).find('input:text, select');
            
            inputs.each(function(index, item) {
                // console.log($(item));
                var prefix = $(item).attr('name').substring(0, $(this).attr('name').indexOf('['));
                var subfix = $(item).attr('name').substring($(this).attr('name').indexOf(']') + 1, $(this).attr('name').length);
                $(this).attr('name', prefix + "[" + i + "]" + subfix);
            })
            i += 1;
            console.log($(item));
        });
    });
}

function removeTableRow(row) {

    if($(".first-input", row).val() === '1') {
        $(".first-input", row).val('2');
    }
    
    row.hide();
}

const btns = $(".collapse-btn");

btns[0].addEventListener('click', (e) => {
    e.stopPropagation;
    $(e.target).parents().nextAll().nextAll("table").toggle();
    $(".header").toggle();
    $(".new-milestone-table").toggle();
})

btns[2].addEventListener('click', (e) => {
    e.stopPropagation;
    var table = $(e.target).parent().next().find('table');
    $(table).toggle();
})

for(var i = 1; i < btns.length; i++) {    
    if(i != 2){
        btns[i].addEventListener('click', (e) => {
            e.stopPropagation;
            $(e.target).parents().next('table').toggle();
        })
    }
    
}
