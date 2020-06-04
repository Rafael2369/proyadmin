// A $( document ).ready() block.
$( document ).ready(function() {
  $("#container2").load($("#PER_TIPOUSUARIO").val()); 
});

$("#PER_TIPOUSUARIO").on("click", function(){
    let valor = $(this).val();
    $("#container2").load(valor);
});
