<#import "/layout/list_layout.ftl" as layout>
    <@layout.list_layout "${PageTitle}" >


    <style>
        .live-demo-container {
            padding-top: 20px;
            overflow-x: auto;
        }
        .filter input[type="text"]{
            -webkit-appearance: textfield;
        }
        .dhx_cell_statusbar_paging .dhx_toolbar_material {
            box-shadow: none;
        }
        .dhx_cell_cont_layout {
            overflow: hidden;
        }
        div.gridbox_material.gridbox table.obj tr.rowselected td:first-child {
            border-left: 3px solid #39c;
            padding-left: 11px;
        }
        div.gridbox_material.gridbox table.obj tr td:first-child {
            padding-left: 14px;
        }
        div.gridbox_material.gridbox table.obj tr td:last-child {
            padding-right: 10px;
        }
        div.gridbox_material.gridbox table.hdr td:first-child div.hdrcell {
            padding-left: 14px;
        }
    </style>

    <script>

        //dhx_cell_hdr



        dhtmlxEvent(window, "load", function(){

            var myToolbar = new dhtmlXToolbarObject("toolbarObj");

            myToolbar.loadStruct("toolbarJson","js");

            var myLayout = new dhtmlXLayoutObject("layoutObj", "1C");
            myLayout.cells("a").setText(" ${PageTitle} ");
            myLayout.cells("a").attachStatusBar({
                text: "<div id='pagingArea'></div>",
                paging: true
            });

            var myGrid = myLayout.cells("a").attachGrid();
            myGrid.setImagePath("/assets/images/");
            myGrid.enablePaging(true, 10, 3, "pagingArea");
            myGrid.setPagingSkin("toolbar");

            myGrid.init();
            myGrid.load("json","js");
        });

    </script>

    <div id="toolbarObj"></div>
    <div id="layoutObj" style="height:350px; background-color:white;"></div>




</@layout.list_layout>