<template>
  	<div class="waifu">
		    
		    <!-- 提示框 -->
		    <div class="waifu-tips"></div>
		    
		    <!-- 看板娘画布 -->
		    <canvas id="live2d" class="live2d"></canvas>
		    
		    <!-- 工具栏 -->
		    <div class="waifu-tool">
		        <span class="fui-home"></span>
		        <span class="fui-chat"></span>
		        <span class="fui-eye"></span>
		        <span class="fui-user"></span>
		        <span class="fui-photo"></span>
		        <span class="fui-info-circle"></span>
		        <span class="fui-cross"></span>
		    </div>
		    
		</div>
</template>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="../liveqwq/live2d_demo-master/assets/autoload.js" type="text/javascript"></script>

<script>
export default {

}
</script>
<style scoped>
@import '../liveqwq/live2d_demo-master/assets/waifu.css';

</style>