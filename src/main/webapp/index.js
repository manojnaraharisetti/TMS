(function () {
    $('.btn').click(function () {
      $(this).toggleClass('active');
      return $('.box').toggleClass('open');
    });

  }).call(this);


  $(document).ready(function () {
	  $("#do_login").click(function () {
	    closeLoginInfo();
	    $(this).parent().find('span').css("display", "none");
	    $(this).parent().find('span').removeClass("i-save");
	    $(this).parent().find('span').removeClass("i-warning");
	    $(this).parent().find('span').removeClass("i-close");

	    var proceed = true;
	    $("#login_form input").each(function () {

	      if (!$.trim($(this).val())) {
	        $(this).parent().find('span').addClass("i-warning");
	        $(this).parent().find('span').css("display", "block");
	        proceed = false;
	      }
	    });

	    if (proceed) //everything looks good! proceed...
	    {
	      $(this).parent().find('span').addClass("i-save");
	      $(this).parent().find('span').css("display", "block");
	    }
	  });

	  //reset previously results and hide all message on .keyup()
	  $("#login_form input").keyup(function () {
	    $(this).parent().find('span').css("display", "none");
	  });

	  openLoginInfo();
	  setTimeout(closeLoginInfo, 1000);
	});

	function openLoginInfo() {
	  $(document).ready(function () {
	    $('.b-form').css("opacity", "0.01");
	    $('.box-form').css("left", "-37%");
	    $('.box-info').css("right", "-37%");
	  });
	}

	function closeLoginInfo() {
	  $(document).ready(function () {
	    $('.b-form').css("opacity", "1");
	    $('.box-form').css("left", "0px");
	    $('.box-info').css("right", "-5px");
	  });
	}

	$(window).on('resize', function () {
	  closeLoginInfo();
	});


	// fireflies animation
	// init
	var maxx = document.body.clientWidth;
	var maxy = document.body.clientHeight;
	var halfx = maxx / 2;
	var halfy = maxy / 2;
	var canvas = document.createElement("canvas");
	document.body.appendChild(canvas);
	canvas.width = maxx;
	canvas.height = maxy;
	var context = canvas.getContext("2d");
	var dotCount = 200;
	var dots = [];
	
	// create dots
	for (var i = 0;i<dotCount ; i++) {
	  dots.push(new dot());
	}

	// dots animation
	function render() {
	  context.fillStyle = "#000000";
	  context.fillRect(0, 0, maxx, maxy);
	  for (var i = 0; i < dotCount; i++) {
	    dots[i].draw();
	    dots[i].move();
	  }
	  requestAnimationFrame(render);
	}

	// dots class
	// @constructor
	function dot() {

	  this.rad_x = 2 * Math.random() * halfx + 1;
	  this.rad_y = 1.2 * Math.random() * halfy + 1;
	  this.alpha = Math.random() * 360 + 1;
	  this.speed = Math.random() * 200 < 50 ? 1 : -1;
	  this.speed *= 0.1;
	  this.size = Math.random() * 5 + 1;
	  this.color = Math.floor(Math.random() * 256);

	}

	// drawing dot
	dot.prototype.draw = function () {

	  // calc polar coord to decart
	  var dx = halfx + this.rad_x * Math.cos(this.alpha / 180 * Math.PI);
	  var dy = halfy + this.rad_y * Math.sin(this.alpha / 180 * Math.PI);
	  // set color
	  context.fillStyle = "rgb(" + this.color + "," + this.color + "," + this.color + ")";
	  // draw dot
	  context.fillRect(dx, dy, this.size, this.size);

	};

	// calc new position in polar coord
	dot.prototype.move = function () {

	  this.alpha += this.speed;
	  // change color
	  if (Math.random() * 100 < 50) {
	    this.color += 1;
	  } else {
	    this.color -= 1;
	  }

	};

	// start animation
	render();