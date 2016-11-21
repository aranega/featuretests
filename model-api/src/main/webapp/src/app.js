/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
(function (ng) {
    var mod = ng.module('mainApp', [
        //'ngCrudMock',
        'ngCrud',
        'ui.router',
        'circleModule',
        'shapeModule',
        'squareModule',
        'aModule',
        'authModule'
    ]);

    mod.constant('baseUrl', 'api');

    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['RestangularProvider', 'baseUrl', function (rp, baseUrl) {
            rp.setBaseUrl(baseUrl);
            rp.setRequestInterceptor(function (elem, operation) {
                if (operation === "remove") {
                    return null;
                }
                return elem;
            });
            rp.addResponseInterceptor(function (data, operation, what, url, response) {
                if (operation === "getList") {
                    data.totalRecords = parseInt(response.headers("X-Total-Count")) || 1;
                }
                return data;
            });
        }]);

    mod.config(['$urlRouterProvider', function ($urlRouterProvider) {
                $urlRouterProvider.otherwise('/');
        }]);

    mod.config(['authServiceProvider', 'baseUrl', function (auth, baseUrl) {
            auth.setValues({
                apiUrl: baseUrl + '/users/',
                successState: 'circleList'
            });
        }]);

    /*
     * When there's an error changing state, ui-router doesn't raise an error
     * This configuration allows to print said errors
     */
    mod.run(['$rootScope', '$log', function ($rootScope, $log) {
            $rootScope.$on('$stateChangeError', function (event, toState, toParams, fromState, fromParams, error) {
                $log.warn(error);
            });
        }]);
})(window.angular);
