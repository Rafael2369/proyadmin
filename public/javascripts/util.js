$(document).ready(function() {
    $('[data-tooltip="tooltip"]').tooltip();
    $(".divModal").hide();
    $("span.guardar").addClass("fa fa-save");
    $("button.guardar").addClass("btn btn-success");
    $("span.cancelar").addClass("fa fa-times-circle");
    $("button.cancelar").addClass("btn btn-danger");
    $(".text").addClass("form-control");
    $("#divAleta").hide();
});

function dataBox(data,id,texto){
	var arr="";
	var result="";
	var coma ="";
	var cont =1;
	for (x in data) {
		if(data.length == cont){
			coma="";	
		}
		else{
			coma=",";
		}
		result += JSON.stringify(data[(x)]).replace(id,"id").replace(texto,"text")+coma;
		cont ++;
	}
	arr= "["+result+"]";
	return JSON.parse(arr);
}
$("input").keypress(function(){
		convertirAmayuscula($(this));
	});
	$("input").keyup(function(){
		convertirAmayuscula($(this));
	});
function convertirAmayuscula(x) {
	let id= x.attr("id");
	let valor= x.val();
	$("#"+id).val(valor.toUpperCase());
}


 function alerta(accion, msg){
    let alerta = '<div class="topright alert alert-'+accion+'" alert-dismissible fade show" role="alert"><strong>'+accion+': </strong>'+msg+'<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>';
    $("#divAleta").html(alerta);
    $("#divAleta").fadeIn(2000);
	$("#divAleta").fadeOut(2000);
	
 }

function eachForm(valor){
	let contForm =0;
    $("form").each(function(){
        let id = $(this).attr("id");
        //guardar
        //elimina
        //edit
        $.ajax({
            type: "GET",
            url:valor+id,
            data: $("#"+id).serialize(),
            success: function(data){
                obj(data);
            },
            async:false
        });
		contForm +=1;
		if(contForm == $("form").length){
			alerta("success", "Se guardo con exito");
		}
    });
}


var detalle = new Object();

var personaData;
function persona(valor){
	let id = $(this).attr("id");
	//guardar
	//elimina
	//edit
	$.ajax({
		type: "GET",
		url:valor+"persona",
		data: $("#persona").serialize(),
		success: function(data){
			obj(data);
			personaData=data;
			let mov_id = guardarMovimientos("Ingreso",$("#totalPagar").text(), data);
			$("#tableCar tbody tr").each(function(index) {
				let id=$("#"+$(this).attr("id")+" td").eq(0).html();
				let precioventa=$("#"+$(this).attr("id")+" td").eq(2).html();
				let cantidad = $("#"+$(this).attr("id")+" td .btnSubtotal").val();
				detalle.DET_CANTIDAD =cantidad;
			    detalle.DET_VALOR=precioventa;
				detalle.DET_IDPRODUCTO=id;
				detalle.DET_IDMOVIMIENTO=mov_id;
				guardarDetalle(detalle);
			});
			$("#persona").hide();
			$("#factura").load("factura", function(){
				var persona = personaFindId();				
				$.each(persona, function(i, objpersona) {
					$("#NombreCliente").html(objpersona.PER_NOMBRE+" "+objpersona.PER_APAT+" "+objpersona.PER_AMAT);
					$("#DIRECCION").text(objpersona.PER_DIRECCION);
					$("#TELEFONO").text(objpersona.PER_TELEFONO);
					$("#REFENCIA").text(objpersona.PER_REFERECIA);
				});
				var movimientos =findIdMovimientos();
				var MOV_ID ="";
				$.each(movimientos, function(i, obj) {
					mapForm2(obj);
					MOV_ID = obj.MOV_ID;
					
				});
			
				var objlistmovimientoDetalle = listmovimientoDetalle(MOV_ID);
				$.each(objlistmovimientoDetalle, function(i, obj) {
					$("#tablaFactura tbody").append("<tr><td>"+obj.DET_CANTIDAD+"</td><td>"+obj.PRO_NOMBRE+"</td> <td>"+obj.PRO_PRECIOVENTA+"</td><td>"+obj.DET_VALOR+"</td></tr>");
					
				});
				
				
				
				
			});
			//window.open("factura");
			//pdf();
		},
		async:false
	});
	/*contForm +=1;
	if(contForm == $("form").length){
		alerta("success", "Se guardo con exito");
	}*/
}

function guardarMovimientos(tipo, total,idpersona){
	let mov_id ="";
	$.ajax({
          url: "guardarMovimientos?MOV_TIPO="+tipo+"&MOV_TOTAL="+total+"&MOV_IDPERSONA="+idpersona,
          type: "GET",
          success: function(data) {
			  mov_id = data;
          },
          async: false
      });
	  return mov_id;
}
function findIdMovimientos(){
	let datos ="";
	$.ajax({
          url: "findIdMovimientos?MOV_IDPERSONA="+personaData,
          type: "GET",
          success: function(data) {
			  datos = data;
          },
          async: false
      });
	  return datos;
}

function listmovimientoDetalle(IDMOVIMIENTO){
	let datos ="";
	$.ajax({
          url: "listmovimientoDetalle?DET_IDMOVIMIENTO="+IDMOVIMIENTO,
          type: "GET",
          success: function(data) {
			  datos = data;
          },
          async: false
      });
	  return datos;
}

function guardarDetalle(datos){
	$.ajax({
          url: "guardarDetalle",
          type: "GET",
		  data: datos,
          success: function(data) {
        
          },
          async: false
    });
}

//Factura
function llenaDataFactura(){
	var personaFindId = personaFindId();
	for(var objpersona in personaFindId){
		$("#NombreCliente").html(objpersona.PER_NOMBRE+" "+objpersona.PER_APAT+" "+objpersona.PER_AMAT);
	}
	
}
function personaFindId(){
	var datos;
	$.ajax({
	  url: "personafindId?PER_IDPERSONA="+personaData,
	  type: "GET",
	  //data: personaData,
	  success: function(data) {
		datos = data;
	  },
	  async: false
    });
	return datos;
}

function findCodigoBarra(CODIGOBARRA){
	var datos;
	$.ajax({
	  url: "findCodigoBarra?PRO_CODIGOBARRA="+CODIGOBARRA,
	  type: "GET",
	  success: function(data) {
		datos = data;
	  },
	  async: false
    });
	return datos;
}

//la chinita tenia miedo . y que si y ella que no //
function mapForm(data){
	var jsonData = [data]; 
	for(var obj in jsonData){
		if(jsonData.hasOwnProperty(obj)){
			for(var prop in jsonData[obj]){
				if(jsonData[obj].hasOwnProperty(prop)){
					var id = "#"+prop;
					var valor = jsonData[obj][prop];
					if($("#"+prop).prop("tagName") == "SELECT"){			
						$(id+" [value='"+valor+"']").prop("selected","selected").parent().trigger('change');
					}else if($("#"+prop).prop("tagName") != "SELECT"){
						$(id).val(valor);
					}
				}
			}
		}
	}    
  }
  function mapForm2(data){
	var jsonData = data; 
	for(var obj in jsonData){
		if(jsonData.hasOwnProperty(obj)){
			$("#"+obj).html(jsonData[obj]);
		}
	}    
  }
  
$(".guardar").on("click",function(){
    eachForm("guardar");
});

function obj(valor){
    $("#USU_IDPERSONA").val(valor);
}

function getValDraw(valor){
    datodraw(valor);
}

function pdf(){
		
var pdf = new jsPDF('p', 'pt', 'letter')
// source can be HTML-formatted string, or a reference
// to an actual DOM element from which the text will be scraped.
, source = $('#factura')[0]

// we support special element handlers. Register them with jQuery-style
// ID selector for either ID or node name. ("#iAmID", "div", "span" etc.)
// There is no support for any other type of selectors
// (class, of compound) at this time.
, specialElementHandlers = {
    // element with id of "bypass" - jQuery style selector
    '#bypassme': function(element, renderer){
        // true = "handled elsewhere, bypass text extraction"
        return true
    }
}

margins = {
    top: 80,
    bottom: 60,
    left: 40,
    width: 522
  };
  // all coords and widths are in jsPDF instance's declared units
  // 'inches' in this case
pdf.fromHTML(
    source // HTML string or DOM elem ref.
    , margins.left // x coord
    , margins.top // y coord
    , {
        'width': margins.width // max width of content on PDF
        , 'elementHandlers': specialElementHandlers
    },
    function (dispose) {
      // dispose: object with X, Y of the last line add to the PDF
      //          this allow the insertion of new lines after html
        pdf.save('Test.pdf');
      },
    margins
  )
	
}

function datodraw(valor){
    var id = $(valor).attr("id");
    var num = $("#"+id).val();
    if(num > 0){
        if(id != "datodraw2" && id != "datodraw3"){
            table.page(parseInt(num-1)).draw(false);
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


