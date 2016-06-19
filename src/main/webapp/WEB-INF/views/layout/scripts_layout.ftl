        <!-- start: MAIN JAVASCRIPTS -->
        <!--[if lt IE 9]>
            <script src="/assets/bower_components/respond/dest/respond.min.js"></script>
            <script src="/assets/bower_components/Flot/excanvas.min.js"></script>
            <script src="/assets/bower_components/jquery-1.x/dist/jquery.min.js"></script>
            <![endif]-->
        <!--[if gte IE 9]><!-->
        <script type="text/javascript" src="/assets/bower_components/jquery/dist/jquery.min.js"></script>
        <!--<![endif]-->

        <script type="text/javascript" src="/assets/bower_components/jquery-ui/jquery-ui.min.js"></script>
        <script type="text/javascript" src="/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/assets/bower_components/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"></script>
        <script type="text/javascript" src="/assets/bower_components/blockUI/jquery.blockUI.js"></script>
        <script type="text/javascript" src="/assets/bower_components/iCheck/icheck.min.js"></script>
        <script type="text/javascript" src="/assets/bower_components/perfect-scrollbar/js/min/perfect-scrollbar.jquery.min.js"></script>
        <script type="text/javascript" src="/assets/bower_components/jquery.cookie/jquery.cookie.js"></script>
        <script type="text/javascript" src="/assets/bower_components/sweetalert/dist/sweetalert.min.js"></script>
        <script type="text/javascript" src="/assets/js/min/main.min.js"></script>
        <!-- end: MAIN JAVASCRIPTS -->
        <!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
        <#--<script src="/assets/bower_components/Flot/jquery.flot.js"></script>
        <script src="/assets/bower_components/Flot/jquery.flot.pie.js"></script>
        <script src="/assets/bower_components/Flot/jquery.flot.resize.js"></script>-->
        <script src="/assets/plugin/jquery.sparkline.min.js"></script>
        <script src="/assets/bower_components/jquery.easy-pie-chart/dist/jquery.easypiechart.min.js"></script>
        <script src="/assets/bower_components/jqueryui-touch-punch/jquery.ui.touch-punch.min.js"></script>
        <script src="/assets/bower_components/moment/min/moment.min.js"></script>
        <script src="/assets/bower_components/fullcalendar/dist/fullcalendar.min.js"></script>
        <script src="/assets/js/min/index.min.js"></script>


        <script type="text/javascript" src="/assets/js/prettify.min.js"></script>
        <script src="/assets/js/multiselect.js"></script>
        <script src="/assets/js/dhtmlx.js"></script>
        <script src="/assets/bower_components/ladda-bootstrap/dist/spin.min.js"></script>
        <script src="/assets/bower_components/ladda-bootstrap/dist/ladda.min.js"></script>
        <script src="/assets/bower_components/bootstrap-switch/dist/js/bootstrap-switch.min.js"></script>
        <script src="/assets/bower_components/bootstrap-fileinput/js/plugins/canvas-to-blob.min.js"></script>
        <script src="/assets/bower_components/bootstrap-fileinput/js/fileinput.min.js"></script>
        <script src="/assets/js/min/form-elements.min.js"></script>
        <script src="/assets/js/min/ui-buttons.min.js"></script>
        <!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->

        <script>
            jQuery(document).ready(function(){
                $(".dhtmlx-info dhtmlx-error").hide();

                // make code pretty
                window.prettyPrint && prettyPrint();

                if ( window.location.hash ) {
                    scrollTo(window.location.hash);
                }

                $('.nav').on('click', 'a', function(e) {
                    scrollTo($(this).attr('href'));
                });

                $('#multiselect').multiselect();

                $('#search').multiselect({
                    search: {
                        left: '<input type="text" name="q" class="form-control" placeholder="Search..." />',
                        right: '<input type="text" name="q" class="form-control" placeholder="Search..." />',
                    }
                });

                $('.multiselect').multiselect();
                $('.js-multiselect').multiselect({
                    right: '#js_multiselect_to_1',
                    rightAll: '#js_right_All_1',
                    rightSelected: '#js_right_Selected_1',
                    leftSelected: '#js_left_Selected_1',
                    leftAll: '#js_left_All_1'
                });

                $('#keepRenderingSort').multiselect({
                    keepRenderingSort: true
                });

                $('#undo_redo').multiselect();

                $('#multi_d').multiselect({
                    right: '#multi_d_to, #multi_d_to_2',
                    rightSelected: '#multi_d_rightSelected, #multi_d_rightSelected_2',
                    leftSelected: '#multi_d_leftSelected, #multi_d_leftSelected_2',
                    rightAll: '#multi_d_rightAll, #multi_d_rightAll_2',
                    leftAll: '#multi_d_leftAll, #multi_d_leftAll_2',

                    search: {
                        left: '<input type="text" name="q" class="form-control" placeholder="Search..." />'
                    },

                    moveToRight: function(Multiselect, $options, event, silent, skipStack) {
                        var button = $(event.currentTarget).attr('id');

                        if (button == 'multi_d_rightSelected') {
                            var $left_options = Multiselect.$left.find('> option:selected');
                            Multiselect.$right.eq(0).append($left_options);

                            if ( typeof Multiselect.callbacks.sort == 'function' && !silent ) {
                                Multiselect.$right.eq(0).find('> option').sort(Multiselect.callbacks.sort).appendTo(Multiselect.$right.eq(0));
                            }
                        } else if (button == 'multi_d_rightAll') {
                            var $left_options = Multiselect.$left.children(':visible');
                            Multiselect.$right.eq(0).append($left_options);

                            if ( typeof Multiselect.callbacks.sort == 'function' && !silent ) {
                                Multiselect.$right.eq(0).find('> option').sort(Multiselect.callbacks.sort).appendTo(Multiselect.$right.eq(0));
                            }
                        } else if (button == 'multi_d_rightSelected_2') {
                            var $left_options = Multiselect.$left.find('> option:selected');
                            Multiselect.$right.eq(1).append($left_options);

                            if ( typeof Multiselect.callbacks.sort == 'function' && !silent ) {
                                Multiselect.$right.eq(1).find('> option').sort(Multiselect.callbacks.sort).appendTo(Multiselect.$right.eq(1));
                            }
                        } else if (button == 'multi_d_rightAll_2') {
                            var $left_options = Multiselect.$left.children(':visible');
                            Multiselect.$right.eq(1).append($left_options);

                            if ( typeof Multiselect.callbacks.sort == 'function' && !silent ) {
                                Multiselect.$right.eq(1).eq(1).find('> option').sort(Multiselect.callbacks.sort).appendTo(Multiselect.$right.eq(1));
                            }
                        }
                    },

                    moveToLeft: function(Multiselect, $options, event, silent, skipStack) {
                        var button = $(event.currentTarget).attr('id');

                        if (button == 'multi_d_leftSelected') {
                            var $right_options = Multiselect.$right.eq(0).find('> option:selected');
                            Multiselect.$left.append($right_options);

                            if ( typeof Multiselect.callbacks.sort == 'function' && !silent ) {
                                Multiselect.$left.find('> option').sort(Multiselect.callbacks.sort).appendTo(Multiselect.$left);
                            }
                        } else if (button == 'multi_d_leftAll') {
                            var $right_options = Multiselect.$right.eq(0).children(':visible');
                            Multiselect.$left.append($right_options);

                            if ( typeof Multiselect.callbacks.sort == 'function' && !silent ) {
                                Multiselect.$left.find('> option').sort(Multiselect.callbacks.sort).appendTo(Multiselect.$left);
                            }
                        } else if (button == 'multi_d_leftSelected_2') {
                            var $right_options = Multiselect.$right.eq(1).find('> option:selected');
                            Multiselect.$left.append($right_options);

                            if ( typeof Multiselect.callbacks.sort == 'function' && !silent ) {
                                Multiselect.$left.find('> option').sort(Multiselect.callbacks.sort).appendTo(Multiselect.$left);
                            }
                        } else if (button == 'multi_d_leftAll_2') {
                            var $right_options = Multiselect.$right.eq(1).children(':visible');
                            Multiselect.$left.append($right_options);

                            if ( typeof Multiselect.callbacks.sort == 'function' && !silent ) {
                                Multiselect.$left.find('> option').sort(Multiselect.callbacks.sort).appendTo(Multiselect.$left);
                            }
                        }
                    }
                });

                $("#optgroup").multiselect();


                Main.init();
                Index.init();
                UIButtons.init();
            });


            function scrollTo( id ) {
                if ( $(id).length ) {
                    $('html,body').animate({scrollTop: $(id).offset().top - 60},'slow');
                }
            }
        </script>
