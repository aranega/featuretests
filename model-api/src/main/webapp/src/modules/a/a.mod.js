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
    var mod = ng.module('aModule', ['ngCrud', 'ui.router']);

    mod.constant('aModel', {
        name: 'a',
        displayName: 'A',
		url: 'as',
        fields: {
        }
    });

    mod.config(['$stateProvider',
        function($sp){
            var basePath = 'src/modules/a/';
            var baseInstancePath = basePath + 'instance/';

            $sp.state('a', {
                url: '/as?page&limit',
                abstract: true,
                
                views: {
                     mainView: {
                        templateUrl: basePath + 'a.tpl.html',
                        controller: 'aCtrl'
                    }
                },
                resolve: {
                    model: 'aModel',
                    as: ['Restangular', 'model', '$stateParams', function (r, model, $params) {
                            return r.all(model.url).getList($params);
                        }]
                }
            });
            $sp.state('aList', {
                url: '/list',
                parent: 'a',
                views: {
                    aView: {
                        templateUrl: basePath + 'list/a.list.tpl.html',
                        controller: 'aListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('aNew', {
                url: '/new',
                parent: 'a',
                views: {
                    aView: {
                        templateUrl: basePath + 'new/a.new.tpl.html',
                        controller: 'aNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('aInstance', {
                url: '/{aId:int}',
                abstract: true,
                parent: 'a',
                views: {
                    aView: {
                        template: '<div ui-view="aInstanceView"></div>'
                    }
                },
                resolve: {
                    a: ['as', '$stateParams', function (as, $params) {
                            return as.get($params.aId);
                        }]
                }
            });
            $sp.state('aDetail', {
                url: '/details',
                parent: 'aInstance',
                views: {
                    aInstanceView: {
                        templateUrl: baseInstancePath + 'detail/a.detail.tpl.html',
                        controller: 'aDetailCtrl'
                    }
                }
            });
            $sp.state('aEdit', {
                url: '/edit',
                sticky: true,
                parent: 'aInstance',
                views: {
                    aInstanceView: {
                        templateUrl: baseInstancePath + 'edit/a.edit.tpl.html',
                        controller: 'aEditCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('aDelete', {
                url: '/delete',
                parent: 'aInstance',
                views: {
                    aInstanceView: {
                        templateUrl: baseInstancePath + 'delete/a.delete.tpl.html',
                        controller: 'aDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
	}]);
})(window.angular);
