
layui.use(['layer','element'], function () {

    var layer = layui.layer,
        $ = layui.jquery;

    $(document).on('click', 'a.my-link', function() {
        var src = $(this).attr('href-url');
        layer.msg(src);
        window.location = src;
    });
});