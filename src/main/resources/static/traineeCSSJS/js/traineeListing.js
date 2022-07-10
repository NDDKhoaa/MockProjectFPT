$("#checkAll").click(function () {
    $('input:checkbox').not(this).prop('checked', this.checked);
});

$(function(){
    // bind change event to select
    $('#dynamic_select').on('change', function () {
        var url = $(this).val(); // get selected value
        if (url) { // require a URL
            window.location = url; // redirect
        }
        return false;
    });
  });

  $(document).ready(function(){
    $("#test_delete").click(function(){
      message();
    });
    $("#cancel").click(function(e){
        $("#delete_message").toggle();
    });
  });

  function message()
  {
    const traineeId = $('input:checkbox:checked').not($("#checkAll"));
    if(traineeId.length === 0) {
        $("#nothing_message").toggle()
    } else {
        $("#delete_message").toggle();
    }
    
  }

    const updateBtn = $('.updateBtn');
    $(updateBtn).click(function(e) {
        const traineeId = $('input:checkbox:checked').not($("#checkAll"));
        
        if(traineeId.length === 1) {
            updateBtn.attr('href', 'http://localhost:8080/getTraineeInfo?id=' + traineeId.val());
        } else {
            e.preventDefault();
            $("#validation_message").toggle();
        }
       
    })
    $(document).ready(function(){
        $("#cancel1").click(function(e){
            $("#validation_message").toggle();
        });
    });
    $(document).ready(function(){
        $("#cancel2").click(function(e){
            $("#nothing_message").toggle();
        });
    });