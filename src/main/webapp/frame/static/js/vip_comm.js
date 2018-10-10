/**
 * @name:   vip-admin 后台模板主入口
 * @author: 随丶
 */

// 配置
layui.config({
    base: './frame/static/js/'  // 模块目录
}).extend({                     // 模块别名
    vip_nav: 'vip_nav'
    , vip_tab: 'vip_tab'
    , vip_table: 'vip_table'
});

// 主入口方法
layui.use(['layer', 'element', 'util'], function () {

    // 操作对象
    var device = layui.device()
        , element = layui.element
        , layer = layui.layer
        , util = layui.util
        , $ = layui.jquery
        , side = $('.my-side')
        , body = $('.my-body')
        , footer = $('.my-footer');

    //阻止IE7以下访问
    if (device.ie && device.ie < 8) {
        layer.alert('如果您非得使用ie浏览vip-admin 后台模板，那么请使用ie8+');
    }

    // 导航栏收缩
    function navHide(t, st) {
        var time = t ? t : 50;
        st ? localStorage.log = 1 : localStorage.log = 0;
        side.animate({'left': -200}, time);
        body.animate({'left': 0}, time);
        footer.animate({'left': 0}, time);
    }

    // 导航栏展开
    function navShow(t, st) {
        var time = t ? t : 50;
        st ? localStorage.log = 0 : localStorage.log = 1;
        side.animate({'left': 0}, time);
        body.animate({'left': 200}, time);
        footer.animate({'left': 200}, time);
    }

    // 监听导航栏收缩
    $('.btn-nav').on('click', function () {
        if (localStorage.log == 0) {
            navShow(50);
        } else {
            navHide(50);
        }
    });

    // 根据导航栏text获取lay-id
    function getTitleId(card, title) {
        var id = -1;
        $(document).find(".layui-tab[lay-filter=" + card + "] ul li").each(function () {
            if (title === $(this).find('span').html()) {
                id = $(this).attr('lay-id');
            }
        });
        return id;
    }

    // 添加TAB选项卡
    window.addTab = function (elem, tit, url) {
        var card = 'card';                                              // 选项卡对象
        var title = tit ? tit : elem.children('a').html();              // 导航栏text
        var src = url ? url : elem.children('a').attr('href-url');      // 导航栏跳转URL
        var id = new Date().getTime();                                  // ID
        // 切换相应的ID tab
        element.tabChange(card, id);
        // 提示信息
        // layer.msg(title);
    };

    // 监听顶部左侧导航
    element.on('nav(side-top-left)', function (elem) {
        // 添加tab方法
        window.addTab(elem);
    });

    // 监听导航(side-main)点击切换页面
    element.on('nav(side-main)', function (elem) {
        var src = elem.children('a').attr('href-url');      // 导航栏跳转URL
        $(document).find('body .my-body').html('<iframe src="' + src + '" frameborder="0"></iframe>');
    });

    // 皮肤
    function skin() {
        var skin = localStorage.skin ? localStorage.skin : 0;
        var body = $('body');
        body.removeClass('skin-0');
        body.removeClass('skin-1');
        body.removeClass('skin-2');
        body.addClass('skin-' + skin);
    }

    // 工具
    function _util() {
        var bar = $('.layui-fixbar');
        // 分辨率小于1023  使用内部工具组件
        if ($(window).width() < 1023) {
            util.fixbar({
                bar1: '&#xe602;'
                , css: {left: 10, bottom: 54}
                , click: function (type) {
                    if (type === 'bar1') {
                        //iframe层
                        layer.open({
                            type: 1,                        // 类型
                            title: false,                   // 标题
                            offset: 'l',                    // 定位 左边
                            closeBtn: 0,                    // 关闭按钮
                            anim: 0,                        // 动画
                            shadeClose: true,               // 点击遮罩关闭
                            shade: 0.8,                     // 半透明
                            area: ['150px', '100%'],        // 区域
                            skin: 'my-mobile',              // 样式
                            content: $('body .my-side').html() // 内容
                        });
                    }
                    element.init();
                }
            });
            bar.removeClass('layui-hide');
            bar.addClass('layui-show');
        } else {
            bar.removeClass('layui-show');
            bar.addClass('layui-hide');
        }
    };

    // 自适应
    $(window).on('resize', function () {
        if ($(window).width() > 1023) {
            navShow(10);
        } else {
            navHide(10);
        }
        _util();
    });

    // 监听控制content高度
    function init() {
        // 起始判断-收缩/展开
        if (!localStorage.log) {
            if ($(window).width() > 1023) {
                if (localStorage.log == 0) {
                    navHide(10);
                } else {
                    navShow(10);
                }
            } else {
                navHide(10);
            }
        } else {
            if (localStorage.log == 0) {
                navHide(10);
            } else {
                navShow(10);
            }
        }
        // 工具
        _util();
        // skin
        skin();
        // 选项卡高度
        cardTitleHeight = $(document).find(".layui-tab[lay-filter='card'] ul.layui-tab-title").height();
        // 需要减去的高度
        height = $(window).height() - $('.layui-header').height() - cardTitleHeight - $('.layui-footer').height();
        // 设置高度
        $(document).find(".layui-tab[lay-filter='card'] div.layui-tab-content").height(height - 2);
    }

    // 初始化
    init();
});