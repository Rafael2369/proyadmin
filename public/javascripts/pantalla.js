  /*
                                        $.ajax({
                                          type: "GET",
                                          url:valor+id,
                                          data: $("#"+id).serialize(),
                                          success: function(data){
                                              console.log("----||||----->"+data);
                                              obj(data);
                                          },
                                          async:false
                                      });
                                      */
  getPantalla();

  function getPantalla() {
      $.ajax({
          url: "getPantalla",
          type: "GET",
          success: function(data) {
              generaMenu(data);
          },
          async: false

      });
  }


  function generaMenu(miJSON) {
      //recorre columna
      $.each(miJSON, function(i, item) {
          console.log("---------------------><>>>>>" + JSON.stringify(item));
          if (item.PAN_INIVEL == 1) {
              if (item.PAN_RUTA != "#") {
                  console.log("°" + item.PAN_NOMBRE);
              $("#menu").append('<a class="nav-link collapsed" id="itemMenu' + item.PAN_ID_PANTALLA + '" ruta="'+item.PAN_RUTA+'" name="Oobj.getTitulomenu"  data-toggle="collapse" data-target="#item' + item.PAN_ID_PANTALLA + '" aria-expanded="false" aria-controls="item' + item.PAN_ID_PANTALLA + '" ><div class="sb-nav-link-icon"><i class="menu-icon fas '+item.pan_RUTAICONO+'"></i></div><span class="menu-text">' + item.PAN_NOMBRE + '</span><div class="sb-sidenav-collapse-arrow"><i class=""></i></div></a>');
              
				//$("#menu").append('<li class="" id="item' + item.PAN_ID_PANTALLA + '"><a href="#" id="Oobj.getRuta" name="Oobj.getTitulomenu"  class="dropdown-toggle" onclick="rutamenu(this)"><i class="menu-icon fa fa-Oobj.getRutaicono"></i><span class="menu-text">' + item.PAN_NOMBRE + '</span><b class=""></b></a><b class="arrow"></b><ul id="menu1" class="submenu"></ul></li>');
            } else {
                  console.log("°" + item.PAN_NOMBRE);
				  $("#menu").append('<a class="nav-link collapsed" id="itemMenu' + item.PAN_ID_PANTALLA + '" ruta="'+item.PAN_RUTA+'" name="Oobj.getTitulomenu"  data-toggle="collapse" data-target=".item' + item.PAN_ID_PANTALLA + '" aria-expanded="false" aria-controls="item' + item.PAN_ID_PANTALLA + '" ><div class="sb-nav-link-icon"><i class="menu-icon fas '+item.pan_RUTAICONO+'"></i></div><span class="menu-text">' + item.PAN_NOMBRE + '</span><div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div></a>');
              
                  //$("#menu").append('<li class="" id="itemMenu' + item.PAN_ID_PANTALLA + '"><a href="#" id="@obj.getRuta" name="@obj.getTitulomenu"  class="dropdown-toggle" onclick="rutamenu(this)"><i class="menu-icon fa fa-@obj.getRutaicono"></i><span class="menu-text">' + item.PAN_NOMBRE + '</span><b class="arrow fa fa-angle-down"></b></a><b class="arrow"></b><ul id="menu1" class="submenu"></ul></li>');
           



			}

          }
/*
          if (item.PAN_INIVEL == 3) {
              $(document).ready(function() {
                  console.log("|||---" + item.PAN_NOMBRE);
                  $("#item" + PAN_ID_PANTALLA_PADRE + " #menu2").append('<li class=""><a href="#" id="@obj.getRuta" onclick="rutamenu(this)" ><i class="fa fa-@obj.getRutaicono"></i>' + item.PAN_NOMBRE + '</a><b class="arrow"></b></li>');
              });
          }
*/
      });
	  
	  $.each(miJSON, function(i, item) {
		  if (item.PAN_INIVEL == 2) {
			  console.log("PAN_INIVEL--------->#item" + item.PAN_ID_PANTALLA_PADRE + " #menu1");
			  
	  
			  
			  if (item.PAN_RUTA != "#") {
				  console.log("---12" + item.PAN_NOMBRE);
				  let div = '<div class="collapse item' + item.PAN_ID_PANTALLA_PADRE + '" aria-labelledby="headingTwo" data-parent="#item' + item.PAN_ID_PANTALLA_PADRE + '">';
				  let nav = '<nav class="sb-sidenav-menu-nested nav accordion" id="item' + item.PAN_ID_PANTALLA_PADRE + '">';
				  let boton ='<a class="nav-link collapsed" ruta="'+item.PAN_RUTA+'" data-toggle="collapse" data-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">' + item.PAN_NOMBRE + '<div class="sb-sidenav-collapse-arrow"><!-- <i class="fas fa-angle-down"></i> --></div></a>'
				  let navC ='</nav></div>'
				  
				  $("#itemMenu" + item.PAN_ID_PANTALLA_PADRE).after(div+nav+boton+navC);
			  
				  //$("#item" + item.PAN_ID_PANTALLA_PADRE + " #menu1").append('<li id="item' + item.PAN_ID_PANTALLA + '"> <a href="#" id="@obj.getRuta" name="@obj.getTitulomenu"  class="dropdown-toggle" onclick="rutamenu(this)"><i class="fa fa-@obj.getRutaicono"></i><span class="menu-text">' + item.PAN_NOMBRE + '</span><b class=""></b></a><b class="arrow"></b><ul id="menu2" class="submenu"></ul></li>');
			  } else {
				  console.log("---22" + item.PAN_NOMBRE);
				  
					console.log("---" + item.PAN_NOMBRE);
				  let nav = '<nav class="sb-sidenav-menu-nested nav accordion item' + item.PAN_ID_PANTALLA_PADRE + '">';
				  let boton ='<a class="nav-link collapsed" ruta="'+item.PAN_RUTA+'" data-toggle="collapse" data-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">' + item.PAN_NOMBRE + '<div class="sb-sidenav-collapse-arrow"><svg class="svg-inline--fa fa-angle-down fa-w-10" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="angle-down" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 320 512" data-fa-i2svg=""><path fill="currentColor" d="M143 352.3L7 216.3c-9.4-9.4-9.4-24.6 0-33.9l22.6-22.6c9.4-9.4 24.6-9.4 33.9 0l96.4 96.4 96.4-96.4c9.4-9.4 24.6-9.4 33.9 0l22.6 22.6c9.4 9.4 9.4 24.6 0 33.9l-136 136c-9.2 9.4-24.4 9.4-33.8 0z"></path></svg><!-- <i class="fas fa-angle-down"></i> --></div></a>'
				  let navC ='</nav>'
				  
				  $("#item" + item.PAN_ID_PANTALLA_PADRE + " #menu1").append(nav+boton+navC);
			  
				  
				  
				  //$("#item" + item.PAN_ID_PANTALLA_PADRE + " #menu1").append('<li id="item' + item.PAN_ID_PANTALLA + '"> <a href="#" id="@obj.getRuta" name="@obj.getTitulomenu"  class="dropdown-toggle" onclick="rutamenu(this)"><i class="fa fa-@obj.getRutaicono"></i><span class="menu-text">' + item.PAN_NOMBRE + '</span><b class="arrow fa fa-angle-down"></b></a><b class="arrow"></b><ul id="menu2" class="submenu"></ul></li>');
			  }

		  }
	  });


  }