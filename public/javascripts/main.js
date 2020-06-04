$(document).ready(function(){
	hideallElement();
});
function setObj(key, name) {
}
setObj("nombre", "rafa");
$('[data-toggle="modal"]').on("click", function() {
	console.log("press modal"+$(this).attr("id"));
    cargarDatoModal($(this).attr("alt"), "#modalDiv" + $(this).attr("id"));
});

function hideallElement(){
	$("#titleFormAccion").hide();
}
$("[ruta]").on("click", function() {
    let uri = $(this).attr("ruta");
	if(uri!="#"){	
		$("#titleFormAccion").show();
		$("#tituloModulo").text($(this).text());
		$("#container").load(uri);
	}
});
$("a.nav-link").on("click",function(){
    let uri=$(this).attr("id");
    $.ajax({
        url:uri
    });

});

function cargarDatoModal(title, body) {
    $("#modal-title").html(title);
    //$("#modal-body").html(body);
	$(body).show();
    $("#modalDiv" + $(this).attr("id")).show();
}


$(".card").on("click",function(){
    $(this).class("btn btn-info");
});


function urlGet(){

}

$(document).ready(function() {
    $('[data-tooltip="tooltip"]').tooltip();
    $(".divModal").hide();
    $("span.guardar").addClass("fa fa-save");
    $("button.guardar").addClass("btn btn-success");
    $("span.cancelar").addClass("fa fa-times-circle");
    $("button.cancelar").addClass("btn btn-danger");
    $("type.text").addClass("form-control");

});