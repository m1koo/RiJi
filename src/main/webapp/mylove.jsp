<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Our Love Story</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<style type="text/css">
		@font-face {
			font-family: digit;
			src: url('digital-7_mono.ttf') format("truetype");
		}
	</style>
	<link href="css/default.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/garden.js"></script>
	<script type="text/javascript" src="js/functions.js"></script>
</head>

<body>
<div id="mainDiv">
	<div id="content">
		<div id="code">
			<span class="comments">/**</span><br/>
			<span class="space"/><span class="comments">*/</span><br/>
			Boy i = <span class="keyword">new</span> Boy(<span class="string">"zouzou"</span>);<br/>
			Girl u = <span class="keyword">new</span> Girl(<span class="string">"qianqian"</span>);<br/>
			<span class="comments">// May 24, 2017, hold your hand for the first time and I told you I love you. </span><br/>
			i.love(u);<br/>
			<span class="comments">// Luckily, you accepted and became my girlfriend eversince.</span><br/>
			u.accepted();<br/>

			<span class="comments">// We can't be together every day.</span><br/>

			<span class="comments">// But I miss u every day.</span><br/>
			i.miss(u);<br/>
			<span class="comments">// And take care of u and our love.</span><br/>
			i.takeCareOf(u);<br/>

			<span class="comments">// Fighting!</span><br/>
			i.strive();u.strive();<br/>

			<span class="comments">// Just believe, after a short time, we will live happily ever after.</span><br/>
			i.liveHappilyWith(u);<br/>
		</div>
		<div id="loveHeart">
			<canvas id="garden"></canvas>
			<div id="words">
				<div id="messages">
					shaqian, I have fallen in love with you for
					<div id="elapseClock"></div>
				</div>
				<div id="loveu">
					Love u forever and ever.<br/>
					<div class="signature">- zouzou</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
    var offsetX = $("#loveHeart").width() / 2;
    var offsetY = $("#loveHeart").height() / 2 - 55;
    var together = new Date();
    together.setFullYear(2017, 5, 24);
    together.setHours(20);
    together.setMinutes(0);
    together.setSeconds(0);
    together.setMilliseconds(0);

    if (!document.createElement('canvas').getContext) {
        var msg = document.createElement("div");
        msg.id = "errorMsg";
        msg.innerHTML = "Your browser doesn't support HTML5!<br/>Recommend use Chrome 14+/IE 9+/Firefox 7+/Safari 4+";
        document.body.appendChild(msg);
        $("#code").css("display", "none")
        $("#copyright").css("position", "absolute");
        $("#copyright").css("bottom", "10px");
        document.execCommand("stop");
    } else {
        setTimeout(function () {
            startHeartAnimation();
        }, 5000);

        timeElapse(together);
        setInterval(function () {
            timeElapse(together);
        }, 500);

        adjustCodePosition();
        $("#code").typewriter();
    }
</script>
</body>
</html>
