/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

require.config({
    /* starting point for application */
    'hbs': {
        'disableI18n': true, // This disables the i18n helper and doesn't require the json i18n files (e.g. en_us.json)
        'helperPathCallback': // Callback to determine the path to look for helpers
            function(name) { // ('/template/helpers/'+name by default)
                return 'modules/Helpers';
            },
        'templateExtension': 'html', // Set the extension automatically appended to templates
        'compileOptions': {} // options object which is passed to Handlebars compiler
    },
    'urlArgs': "bust=" + getBustValue(),
    /**
     * Requested as soon as the loader has processed the configuration. It does
     * not block any other require() calls from starting their requests for
     * modules, it is just a way to specify some modules to load asynchronously
     * as part of a config block.
     * @type {Array} An array of dependencies to load.
     */
    'deps': ['marionette'],

    /**
     * The number of seconds to wait before giving up on loading a script.
     * @default 7 seconds
     * @type {Number}
     */
    'waitSeconds': 30,

    'shim': {
        'backbone': {
            'deps': ['underscore', 'jquery'],
            'exports': 'Backbone'
        },
        'jquery-ui': {
            'deps': ['jquery']
        },
        'asBreadcrumbs': {
            'deps': ['jquery'],
            'exports': 'asBreadcrumbs'
        },
        'bootstrap': {
            'deps': ['jquery'],
            'exports': 'jquery'
        },
        'underscore': {
            'exports': '_'
        },
        'marionette': {
            'deps': ['backbone']
        },
        'backgrid': {
            'deps': ['backbone'],
            'exports': 'Backgrid'
        },
        'backgrid-paginator': {
            'deps': ['backbone', 'backgrid']
        },
        'backgrid-filter': {
            'deps': ['backbone', 'backgrid']
        },
        'backgrid-orderable': {
            'deps': ['backbone', 'backgrid'],
        },
        'backgrid-sizeable': {
            'deps': ['backbone', 'backgrid'],
        },
        'backgrid-select-all': {
            'deps': ['backbone', 'backgrid']
        },
        'backgrid-columnmanager': {
            'deps': ['backbone', 'backgrid'],
        },
        'hbs': {
            'deps': ['underscore', 'handlebars']
        },
        'd3': {
            'exports': ['d3']
        },
        'd3-tip': {
            'deps': ['d3'],
            'exports': ['d3-tip']
        },
        'dagreD3': {
            'deps': ['d3'],
            'exports': ['dagreD3']
        },
        'pnotify': {
            'exports': ['pnotify']
        },
        'jquery-placeholder': {
            'deps': ['jquery']
        },
        'query-builder': {
            'deps': ['jquery']
        },
        'daterangepicker': {
            'deps': ['jquery', 'moment']
        },
        'nvd3': {
            'deps': ['d3']
        },
        'sparkline': {
            'deps': ['jquery'],
            'exports': ['sparkline']
        }
    },

    paths: {
        'jquery': 'libs/jquery/js/jquery.min',
        'underscore': 'libs/underscore/underscore-min',
        'bootstrap': 'libs/bootstrap/js/bootstrap.min',
        'backbone': 'libs/backbone/backbone-min',
        'backbone.babysitter': 'libs/backbone.babysitter/lib/backbone.babysitter.min',
        'marionette': 'libs/backbone-marionette/backbone.marionette.min',
        'backbone.paginator': 'libs/backbone-paginator/backbone.paginator.min',
        'backbone.wreqr': 'libs/backbone-wreqr/backbone.wreqr.min',
        'backgrid': 'libs/backgrid/js/backgrid',
        'backgrid-filter': 'libs/backgrid-filter/js/backgrid-filter.min',
        'backgrid-orderable': 'libs/backgrid-orderable-columns/js/backgrid-orderable-columns',
        'backgrid-paginator': 'libs/backgrid-paginator/js/backgrid-paginator.min',
        'backgrid-sizeable': 'libs/backgrid-sizeable-columns/js/backgrid-sizeable-columns',
        'backgrid-columnmanager': 'libs/backgrid-columnmanager/js/Backgrid.ColumnManager',
        'asBreadcrumbs': 'libs/jquery-asBreadcrumbs/js/jquery-asBreadcrumbs.min',
        'd3': 'libs/d3/d3.min',
        'd3-tip': 'libs/d3/index',
        'tmpl': 'templates',
        'requirejs.text': 'libs/requirejs-text/text',
        'handlebars': 'external_lib/require-handlebars-plugin/js/handlebars',
        'hbs': 'external_lib/require-handlebars-plugin/js/hbs',
        'i18nprecompile': 'external_lib/require-handlebars-plugin/js/i18nprecompile',
        'dagreD3': 'libs/dagre-d3/dagre-d3.min',
        'select2': 'libs/select2/select2.full.min',
        'backgrid-select-all': 'libs/backgrid-select-all/backgrid-select-all.min',
        'moment': 'libs/moment/js/moment.min',
        'jquery-ui': 'external_lib/jquery-ui/jquery-ui.min',
        'pnotify': 'external_lib/pnotify/pnotify.custom.min',
        'pnotify.buttons': 'external_lib/pnotify/pnotify.custom.min',
        'pnotify.confirm': 'external_lib/pnotify/pnotify.custom.min',
        'jquery-placeholder': 'libs/jquery-placeholder/js/jquery.placeholder',
        'platform': 'libs/platform/platform',
        'query-builder': 'libs/jQueryQueryBuilder/js/query-builder.standalone.min',
        'daterangepicker': 'libs/bootstrap-daterangepicker/js/daterangepicker',
        'nvd3': 'libs/nvd3/nv.d3.min',
        'sparkline': 'libs/sparkline/jquery.sparkline.min'
    },

    /**
     * If set to true, an error will be thrown if a script loads that does not
     * call define() or have a shim exports string value that can be checked.
     * To get timely, correct error triggers in IE, force a define/shim export.
     * @type {Boolean}
     */
    'enforceDefine': false
});

require(['App',
    'router/Router',
    'utils/CommonViewFunction',
    'utils/Globals',
    'utils/UrlLinks',
    'collection/VEntityList',
    'collection/VTagList',
    'utils/Overrides',
    'bootstrap',
    'd3',
    'select2'
], function(App, Router, CommonViewFunction, Globals, UrlLinks, VEntityList, VTagList) {
    var that = this;
    this.asyncFetchCounter = 5;
    this.entityDefCollection = new VEntityList();
    this.entityDefCollection.url = UrlLinks.entitiesDefApiUrl();
    this.typeHeaders = new VTagList();
    this.typeHeaders.url = UrlLinks.typesApiUrl();
    this.enumDefCollection = new VTagList();
    this.enumDefCollection.url = UrlLinks.enumDefApiUrl();
    this.enumDefCollection.modelAttrName = "enumDefs";
    this.classificationDefCollection = new VTagList();

    App.appRouter = new Router({
        entityDefCollection: this.entityDefCollection,
        typeHeaders: this.typeHeaders,
        enumDefCollection: this.enumDefCollection,
        classificationDefCollection: this.classificationDefCollection
    });

    var startApp = function() {
        if (that.asyncFetchCounter === 0) {
            App.start();
        }
    };
    CommonViewFunction.userDataFetch({
        url: UrlLinks.sessionApiUrl(),
        callback: function(response) {
            if (response && response.userName) {
                Globals.userLogedIn.status = true;
                Globals.userLogedIn.response = response;
            }
            if (response && response['atlas.feature.taxonomy.enable'] !== undefined) {
                Globals.taxonomy = response['atlas.feature.taxonomy.enable']
            }
            if (response && response['atlas.entity.create.allowed'] !== undefined) {
                Globals.entityCreate = response['atlas.entity.create.allowed'];
            }
            if (response && response['atlas.entity.update.allowed'] !== undefined) {
                Globals.entityUpdate = response['atlas.entity.update.allowed'];
            }
            if (response && response['atlas.ui.editable.entity.types'] !== undefined) {
                var entityTypeList = response['atlas.ui.editable.entity.types'].trim().split(",");
                if (entityTypeList.length) {
                    if (entityTypeList[0] === "*") {
                        Globals.entityTypeConfList = [];
                    } else if (entityTypeList.length > 0) {
                        Globals.entityTypeConfList = entityTypeList;
                    }
                }
            }
            --that.asyncFetchCounter;
            startApp();
        }
    });
    this.entityDefCollection.fetch({
        skipDefaultError: true,
        complete: function() {
            --that.asyncFetchCounter;
            startApp();
        }
    });
    this.typeHeaders.fetch({
        skipDefaultError: true,
        complete: function() {
            --that.asyncFetchCounter;
            startApp();
        }
    });
    this.enumDefCollection.fetch({
        skipDefaultError: true,
        complete: function() {
            --that.asyncFetchCounter;
            startApp();
        }
    });
    this.classificationDefCollection.fetch({
        skipDefaultError: true,
        complete: function() {
            --that.asyncFetchCounter;
            startApp();
        }
    });
});