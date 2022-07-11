const btns = $(".collapse-btn");
console.log('hieu');
btns[0].addEventListener('click', (e) => {
    e.stopPropagation;
    $(e.target).parent().nextAll(".milestone-child-table").toggle();
    $(".header").toggle();
})
$(document).ready(function() {
    btns[2].addEventListener('click', (e) => {
        e.stopPropagation;
        $(e.target).parent().nextAll(".topic-mark-table").find('table').toggle();
        $(e.target).parents().nextAll(".topic-mark-table-final").find('tbody').toggle();
        $(e.target).parents().nextAll(".topic-mark-table-final").find('table').toggle();
    })
});


for(var i = 1; i < btns.length; i++) {    
    if(i != 2){
        btns[i].addEventListener('click', (e) => {
            e.stopPropagation;
            $(e.target).parent().next('table').toggle();
        })
    }
    
}