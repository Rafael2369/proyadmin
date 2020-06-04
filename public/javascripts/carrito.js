let tableCar;
let vargetCategorias ="";
let vargetlistCategoriaArea ="";
let car=[];
let productos;
let numArticulo = 0;
$(document).ready(function(){
	getCategorias();
	getlistCategoriaArea();
	generaMenu();
	getProducto(0);
	inicializarTablaCar();
	$("#realizarPedido").hide();
	$("#divTableCar").hide();
	$("#btnDatosPedido").hide();
	colonia(29950);
});
function colonia(CP){
	$.ajax({
		url:"findColonia?COL_CP="+CP,
		type:"GET",
		success:function(data){
			   $('.colonia option').remove();
			   $.each(data, function(i, list) {
				   $('.colonia').append($('<option>').text(list.COL_TIPO+" "+list.COL_NOMBRE).attr('value', list.COL_ID));
			   });
		},async:false
	});	
}
function getCategorias(){
      $.ajax({
          url: "getCategorias",
          type: "GET",
          success: function(data) {
              //generaMenu(data);
			  vargetCategorias = data;
          },
          async: false

      });
}
function getlistCategoriaArea(){
      $.ajax({
          url: "getlistCategoriaArea",
          type: "GET",
          success: function(data) {
			  vargetlistCategoriaArea = data;
          },
          async: false

      });
 }
 
function baseProducto(id,nombre, precio, estatusProducto, img){
	
	if(isMobile()){
		$(".baseImg").attr("class","baseImg col-sm-6");
	}else{
		$(".baseImg").attr("class","baseImg col-sm-3");
	}
	let b1='';
	let b2='<div class="baseImg col-sm-3">'
	let b3='<div class="atrProducto"><img src="http://192.168.0.5/imagenes/'+img+'" class="img-fluid img-thumbnail" alt="San Fran"><div>'
	let b4='<div class="row"><span class="col-sm-12">'+nombre+'</span></div>'
	let b5='<div class="row"><span class="col-sm-12">'+precio+'</span></div>'
	let b6='<div class="row"> <div class="col-sm-8 divstatus'+estatusProducto+'"><span class="iconstatus'+estatusProducto+'"></span> '+estatusProducto+'</div><div class="col-sm-1"></div>'
	let b7='<button type="button" id="'+id+'" class="btn btn-warning card" data-tooltip="tooltip" data-placement="bottom" title="Agregar al carrito"><span class="fa fa-shopping-cart"></span></button>';
	let b8='</div></div></div></div>'
    return b1+b2+b3+b4+b5+b6+b7+b8;                   
}
function isMobile(){
    return (
        (navigator.userAgent.match(/Android/i)) ||
        (navigator.userAgent.match(/webOS/i)) ||
        (navigator.userAgent.match(/iPhone/i)) ||
        (navigator.userAgent.match(/iPod/i)) ||
        (navigator.userAgent.match(/iPad/i)) ||
        (navigator.userAgent.match(/BlackBerry/i))
    );
}

$("a.nav-link").on("click", function() {
	$(".baseImg").remove();
    let uri = $(this).attr("id");
	estatus = "0";
	if(uri == "Oferta"){
		estatus= "2"
	}else if(uri == "Nuevo"){
		estatus= "1"
	}else if(uri == "Todos"){
		estatus= "0"
	}
    getProducto(estatus)
});
 function getProducto(estatus){	 
      $.ajax({
	  url: "getProducto?PRO_STATUS="+estatus,
	  type: "GET",
	  success: function(data){
			productos ="";
			productos = data;
			$.each(data, function(i, item) {
				$("#CatalogoProducto").append(baseProducto(i,item.PRO_NOMBRE, item.PRO_PRECIOVENTA, statusProAletras(item.PRO_STATUS), item.PRO_FOTO));
			});
	  },
	  async: false
});
$(".card").on("click",function(){
	numArticulo ++;
	$("#NumCompra").html(numArticulo);
	let item= $(this).attr("id");
	
	addCar(productos[item]);
	$("#tableCar #tbodyCar tr").each(function(index) {
	
		var rowData = tableCar.row(index).data();
		$(this).attr("id","tabCar"+index);
	
		let precioventa=$("#tabCar"+index+" td").eq(2).html();
		$("#tabCar"+index+" td .Subtotal").text((1*parseFloat(precioventa)));
		
	});
	totalPagar();
});	

function addCar(producto){
	tableCar.row.add(producto).draw();
	
}

$("#Compra").on("click",function(){	
	$("#divTableCar").show();
	$("#btnDatosPedido").hide();
});	



	$(".iconstatusOFERTA").addClass("fa fa-gift");
	$(".iconstatusNUEVO").addClass("fa fa-tag");
	$(".iconstatusOFERTA").attr("style","color:red");
	$(".iconstatusNUEVO").attr("style","color:#28a745");
	
    
 }
 

function EliminarPordCar(valor){
	numArticulo =numArticulo-1;
	tableCar.row(valor.parents('tr').index()).remove().draw();
	valor.parents('tr').remove();
	$("#NumCompra").html(numArticulo);
	totalPagar();
	
}

 function statusProAletras(data){
	 let result="";
	 if(data == 0){
		 result="";
	 }else if(data == 1){
		 result="NUEVO";
	 }else if(data == 2){
		 result="OFERTA";
	 }else if(data == 3){
		 result="NO DISPONIBLE";
	 }
	 return result;
 }


function  inicializarTablaCar(){
tableCar = $('#tableCar').DataTable({
"ordering": false,
"bFilter": false,
"destroy": true,
 "paging": false,
		   lengthChange: false,
		    pageLength : 150,
        buttons: [{
                text: 'Agregar Producto',
				className: 'Agregar',
                action: function ( e, dt, node, config ) {
					$("#myModal").modal();
					datosModal($(".Agregar span").text(), "Guardar");
				}
            },'copy', 'excel', 'pdf', 'colvis'],
		  language: {
						"sProcessing":     "Procesando...",
						"sLengthMenu":     "Mostrar _MENU_ registros",
						"sZeroRecords":    "No se encontraron resultados",
						"sEmptyTable":     "Ningun dato disponible en esta tabla",
						"sInfo":           "Registros del _START_ al _END_ de un total de _TOTAL_ registros",
						"sInfoEmpty":      "Registros del 0 al 0 de un total de 0 registros",
						"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
						"sInfoPostFix":    "",
						"sSearch":         "Buscar:",
						"sUrl":            "",
						"sInfoThousands":  ",",
						"sLoadingRecords": "Cargando...",
						"oPaginate": {
							"sFirst":    "Primero",
							"sLast":     "ultimo",
							"sNext":     "Siguiente",
							"sPrevious": "Anterior"
						},
						"oAria": {
							"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
							"sSortDescending": ": Activar para ordenar la columna de manera descendente"
						}
					},
					
					/*,
		  columns: [
			  {"data": "name_zon" },
			  {"data": "account_ico" },
			  {"data": "totaldebt_dco" },
			  {"data": "lastdebt_dco" },
			  {"data": "colonia_ico" },
			  {"data": "zip_ico" },
			  {"data": "status_rv" },
			  {"data": "substatus_ico" },
			  {"data": "aviso_ico" },
			  {"data": "tiene_tarjetaasoc" },
			  {"data": "aviso" }
				]
				*/
				columns: [
			  {"data": "PRO_ID"},
			  {"data": "PRO_NOMBRE"},
			  {"data": "PRO_PRECIOVENTA"},
			  {
				  "data": null, // can be null or undefined
				  "defaultContent": '<input type="number" class="form-control-sm btnSubtotal col-sm-4"  onkeyup="setSubtotal($(this))" value="1"/> <label>  $ </label> <label class="Subtotal"></label>'
			},
			{
      "data": null, // can be null or undefined
      "defaultContent": '<div class="btn-group pull-right"><button type="button"  class="btn btn-secondary btnEliminarPordCar" onclick="EliminarPordCar($(this))" data-tooltip="tooltip" data-placement="bottom" title="Eliminar"> <span class="fa fa-trash"></span></button></div>'
    }]		
	  });	
		tableCar.buttons().container().appendTo('#example_wrapper .col-md-6:eq(0)');	
		//cajaText();	

	  }
	  
	  function cajaText(){
		if($("#datodraw").length==0){
		//dataTables_paginate
			//$(".Agregar span").addClass("fa fa-save");
			$(".dataTables_info").before('<input type="text" id="datodraw" class="datodraw form-control input-sm col-sm-2" style="float:right" placeholder="No. pag" size="2" onchange="getValDraw(this)">');
		}
	}
function getValDraw(valor){
    datodraw(valor);
}
$("#btnRealizarPedido").on("click",function(){
	realizarPedido();
	
	
});
function realizarPedido(){
	$("#divTableCar").hide();
	$("#realizarPedido").show();
	$("#btnDatosPedido").show();
	
}

function datodraw(valor){
    var id = $(valor).attr("id");
    var num = $("#"+id).val();
    if(num > 0){
        if(id != "datodraw2" && id != "datodraw3"){
            tableCar.page(parseInt(num-1)).draw(false);
        }else if(id == "datodraw2"){
            tableVisitadorActualizar.page(parseInt(num-1)).draw(false);
        }else if(id == "datodraw3"){
            tableVisitadorEliminar.page(parseInt(num-1)).draw(false);
        }
       $("#"+id).val("");
    }else{
        alert("Favor de ingresar un valor mayor a 0.");
        $("#"+id).val("");
    }
};

function setSubtotal(valor){
	let idfila= valor.parents("tr").attr("id");
	//var rowData = tableCar.row(valor.parents("tr").index()).data();

	let precioventa=$("#"+idfila+" td").eq(2).html();
	let cantidad = valor.val();
	
	if(cantidad==""){
		cantidad = 0;	
	}else if(precioventa==""){
		precioventa = 0;
	}
	
	$("#"+idfila+" td .Subtotal").text(opracionSubtota(cantidad, precioventa));
	totalPagar();
}
function totalPagar(){
	$("#totalPagar").html(0);
	let totalPagar = $("#totalPagar").html();
	$("#tableCar #tbodyCar tr").each(function(index) {
		let subtotalpro = 0;
		subtotalpro = parseFloat($("#tabCar"+index+" td .Subtotal").html());
		if(totalPagar !="" && subtotalpro !="" && subtotalpro>=0 && totalPagar >= 0){
			totalPagar = (parseFloat(totalPagar) + subtotalpro);
		}	
	});
	if(totalPagar>=0){
		$("#totalPagar").text(totalPagar);
	}else{
		$("#totalPagar").text(0);
	}
	
}
function opracionSubtota(cantidad, precioventa){
	if(cantidad==""){
		cantidad = 0;	
	}else if(precioventa==""){
		precioventa = 0;
	}
	let subtotal = parseInt(cantidad)*parseFloat(precioventa);
	return subtotal;
}

//menu
function generaMenu(){
	miJSON=vargetCategorias;
      //recorre columna
      $.each(miJSON, function(i, item) {
		  let btnMenu = '<li class="list-group-item">'+item.CAT_NOMBRE+'<span class="'+item.CAT_AREA+' pull-right"></span></li>'
		  $("#menuCategoria").append(btnMenu);
        
/*

          if (item.PAN_INIVEL == 1) {
              if (item.PAN_RUTA != "#") {
            //      console.log("°" + item.PAN_NOMBRE);
              //$("#menu").append('<a class="nav-link collapsed" id="itemMenu' + item.PAN_ID_PANTALLA + '" ruta="'+item.PAN_RUTA+'" name="Oobj.getTitulomenu"  data-toggle="collapse" data-target="#item' + item.PAN_ID_PANTALLA + '" aria-expanded="false" aria-controls="item' + item.PAN_ID_PANTALLA + '" ><div class="sb-nav-link-icon"><i class="menu-icon fas '+item.pan_RUTAICONO+'"></i></div><span class="menu-text">' + item.PAN_NOMBRE + '</span><div class="sb-sidenav-collapse-arrow"><i class=""></i></div></a>');
              
				//$("#menu").append('<li class="" id="item' + item.PAN_ID_PANTALLA + '"><a href="#" id="Oobj.getRuta" name="Oobj.getTitulomenu"  class="dropdown-toggle" onclick="rutamenu(this)"><i class="menu-icon fa fa-Oobj.getRutaicono"></i><span class="menu-text">' + item.PAN_NOMBRE + '</span><b class=""></b></a><b class="arrow"></b><ul id="menu1" class="submenu"></ul></li>');
            } else {
                  console.log("°" + item.PAN_NOMBRE);
				//  $("#menu").append('<a class="nav-link collapsed" id="itemMenu' + item.PAN_ID_PANTALLA + '" ruta="'+item.PAN_RUTA+'" name="Oobj.getTitulomenu"  data-toggle="collapse" data-target=".item' + item.PAN_ID_PANTALLA + '" aria-expanded="false" aria-controls="item' + item.PAN_ID_PANTALLA + '" ><div class="sb-nav-link-icon"><i class="menu-icon fas '+item.pan_RUTAICONO+'"></i></div><span class="menu-text">' + item.PAN_NOMBRE + '</span><div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div></a>');
              
                  //$("#menu").append('<li class="" id="itemMenu' + item.PAN_ID_PANTALLA + '"><a href="#" id="@obj.getRuta" name="@obj.getTitulomenu"  class="dropdown-toggle" onclick="rutamenu(this)"><i class="menu-icon fa fa-@obj.getRutaicono"></i><span class="menu-text">' + item.PAN_NOMBRE + '</span><b class="arrow fa fa-angle-down"></b></a><b class="arrow"></b><ul id="menu1" class="submenu"></ul></li>');
           



			}

          }

          if (item.PAN_INIVEL == 3) {
              $(document).ready(function() {
                  console.log("|||---" + item.PAN_NOMBRE);
                  $("#item" + PAN_ID_PANTALLA_PADRE + " #menu2").append('<li class=""><a href="#" id="@obj.getRuta" onclick="rutamenu(this)" ><i class="fa fa-@obj.getRutaicono"></i>' + item.PAN_NOMBRE + '</a><b class="arrow"></b></li>');
              });
          }
*/
});


}