$(document).ready(function(){
	$("#PRO_CODIGOBARRA").focus();
	
});
	
$("#btnCODIGOBARRA").on("click",function(){
	agregarACesta();
});
$(document).keypress(function(e) { if(e.which == 13) { e.preventDefault(); // Do something 
	agregarACesta();
}});


$("#PRO_CODIGOBARRA").on("change",function(){
	agregarACesta();
});
function cleanCODIGOBARRA(){
	$("#PRO_CODIGOBARRA").val("");
}

function agregarACesta(){
	
	let codigoBarra = $("#PRO_CODIGOBARRA").val();
	if(VerificarExiteEnLaCesta(codigoBarra)){
		
		
	}else{
		datos  = findCodigoBarra(codigoBarra);
		$("#cesta tbody").append('<tr id="'+datos[0].PRO_CODIGOBARRA+'"><td>'+datos[0].PRO_CODIGOBARRA+'</td><td>'+datos[0].PRO_NOMBRE+'</td><td class="precio">'+datos[0].PRO_PRECIOVENTA+'</td><td class="cantida">1</td><td class="subtotal"></td><td class="text-center"><div class="btn-group"><a href="" class="btn btn-danger btn-xs" title="" data-toggle="tooltip" data-original-title="Delete"><span class="fa fa-trash-alt"></span></a></div></td></tr>');
	}	
	let precio =$("#"+codigoBarra+" .precio").html();
	$("#"+codigoBarra+" .subtotal").html(subTotalProducto($("#"+codigoBarra+" .cantida").html(),precio));
	$("#total").html(total());
	cleanCODIGOBARRA();
}
function delACesta(){

	
}
function VerificarExiteEnLaCesta(codigoBarra){
	let result = false;
	$("#cesta tbody tr").each(function (index) {
		let codigoFila = $(this).attr("id");
		console.log("-------------->"+codigoFila +" === "+ codigoBarra);
		if(codigoFila == codigoBarra){
			result = true
			let antCantidad =$("#"+codigoBarra+" .cantida").html();
			let actcantidad = parseInt(antCantidad) + 1;
			console.log("----->"+actcantidad);
			$("#"+codigoBarra+" .cantida").html(actcantidad);
		}	
	}); 

    
   // $(this).children("td").each(function (index2) {	
   return result;
}
function total(){
	let total = 0;
	$("#cesta tbody tr").each(function (index) {
		let codigoFila = $(this).attr("id");

		let subTotal =$("#"+codigoFila+" .subtotal").html();
		total += parseFloat(subTotal);
		
	});
	return total;
}
function subTotalProducto(cantida, precio){
	let subtotal = 0;
	subtotal = parseInt(cantida) * parseFloat(precio);
	return subtotal;
}
$("#vaciarCesta").on("click",function(){
	let confim = confirm("Desea vaciar la cesta");
	console.log("---->"+ confim);
	if(confim){
		vaciarCesta();
	}
});

function vaciarCesta(){
	console.log("Cesta Vacia");
	$("#cesta tbody tr").remove();
	$("#total").html("0");
}

$("#cobrar").on("click", function(){
	
	
	
});
$("#recibio").on("keyup",function(){
	let recibio = $(this).val();
	let cambio = parseFloat(recibio) - parseFloat($("#total").text());
	$("#cambio").html(cambio);	
});

//cobrar
function cobrar(){
	let cambio = $("#cambio").html();
	if(cambio >= 0){
		//abrir caja
		
		//guardar registro de la compra
		
		
		
	}else{
		alert("Fabor de verificar la cantidad recibida...");
		$("#recibio").focus();
	}
}





