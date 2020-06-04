var table;
$(document).ready(function() {	
	inicializarTabla();   
	getProducto();
$.ajax({
	url:"getMarca",
	type:"GET",
	success:function(data){
		data = dataBox(data,"MAR_ID","MAR_NOMBRE");
		$(".js-example-data-array").select2({ 
			data:data
		 });
	},async:false
});

$.ajax({
	url:"getCategorias",
	type:"GET",
	success:function(data){
		data = dataBox(data,"CAT_ID","CAT_NOMBRE");
		$(".js-example-data-array2").select2({ 
			data:data
		 });
	},async:false
});

$.ajax({
	url:"getPresentacion",
	type:"GET",
	success:function(data){
		data = dataBox(data,"PRE_ID","PRE_NOMBRE");
		$(".Presentacion").select2({ 
			data:data
		 });
	},async:false
});

$.ajax({
	url:"getUnidadMedida",
	type:"GET",
	success:function(data){
		data = dataBox(data,"UNI_ID","UNI_ABREVIATURA");
		$("#PRO_IDUNIDADMEDIDA").select2({ 
			data:data
		 });
	},async:false
});
});

//get data productos
function getProducto(){
	$.ajax({
		url:"getProducto?PRO_STATUS="+0,
		type:"GET",
		success:function(data){	
			table.clear();
			table.rows.add(data);
			table.draw();		
		},
		async: false
	});
}

 $("#guardarProducto").on("click",function(event){
	// Fetch form to apply custom Bootstrap validation
	
	var id = "#producto";
    var form = $(id);
    if (form[0].checkValidity() === false) {
      event.preventDefault()
      event.stopPropagation()
    }else{
	var uri =""; 
	if($(this).hasClass("Guardar")){
		uri ="addProducto";
	}else if($(this).hasClass("Editar")){
		uri ="editProducto"
	}
        $.ajax({
            type: "GET",
			url:uri,
            data: $(id).serialize(),
            success: function(data){
                obj(data);
				getProducto();
				$("#myModal").modal("hide");
            },
            async:false
        });
	}
	form.addClass('was-validated');
    // Perform ajax submit here...
	 
	});
	
	function datosModal(titulo, classAccion){
		cleanForm();
		$("#titulo").html(titulo);
		$("#guardarProducto").removeClass("Editar");
		$("#guardarProducto").removeClass("Guardar");
		$("#guardarProducto").addClass(classAccion);
		
	}
	function cleanForm(){
		$("textarea").val("");
		$("input").val("");
		$(".id").val("0");
	}

function inicializarTabla(){
table = $('#example').DataTable({
		  //"ordering": true,
		  //"bFilter": true,
		   lengthChange: false,
		    pageLength : 5,
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
			  {"data": "PRO_NOMBRE"},
			  {"data": "PRO_DESCRIPCION"},
			  {"data": "PRO_SALDO"},
			  {"data": "PRO_PRECIOVENTA"},
			  {"data": "PRO_FOTO"},
			  {"data": "PRO_CODIGOBARRA"},
			  {"data": "PRO_UBICACION"},
			  {
      "data": null, // can be null or undefined
      "defaultContent": '<div class="btn-group pull-right"><button type="button" class="btn btn-secondary editar" data-tooltip="tooltip" data-target="#myModal" data-toggle="modal" alt="Editar" data-placement="bottom" title="Editar" > <span class="fa fa-edit"></span></button><button type="button" class="btn btn-secondary eliminar" data-tooltip="tooltip" data-placement="bottom" title="Eliminar"> <span class="fa fa-trash"></span></button></div>'
    }
			  
			  
				]			
	  });	
		table.buttons().container().appendTo('#example_wrapper .col-md-6:eq(0)');	
		cajaText();	

	  }
	  
	  
	  
	    
	  $('#example tbody').on('click', '.editar', function () {
		datosModal("Editar Producto", "Editar")
		 var rowData = table.row($(this).parents("tr")).data();
		 mapForm(rowData)

		 //cargarDatoModal("Editar producto", "<li>hola</li>");
    } );
	  
	  $('#example tbody').on('click', '.eliminar', function () {
		  let conf = confirm("Desea eliminar...");
		  if(conf){
			 var rowData = table.row($(this).parents("tr")).data();
			  $.ajax({
					type: "GET",
					url:"delProducto",
					data:rowData,
					success: function(data){
						obj(data);
						getProducto();
					},
					async:false
				});
					 
			 
		  }
    } );
	function cajaText(){
		if($("#datodraw").length==0){
		//dataTables_paginate
			//$(".Agregar span").addClass("fa fa-save");
			$(".dataTables_info").before('<input type="text" id="datodraw" class="datodraw form-control input-sm col-sm-2" style="float:right" placeholder="No. pag" size="2" onchange="getValDraw(this)">');
		}
	}
	$("#PRO_FOTO").on("click",function(){
		let valornombre= $("#PRO_NOMBRE").val();
		$(this).val($("#PRO_IDCATEGORIA option:selected").text()+"/"+valornombre.replace(/ /g, "")+".jpg");	
	});
	
	// Disable form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Get the forms we want to add validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();

	