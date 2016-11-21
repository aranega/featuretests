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
    var mod = ng.module('circleModule', ['ngCrud', 'ui.router']);

    mod.constant('circleModel', {
        name: 'circle',
        displayName: 'Circle',
		url: 'circles',
        fields: {
            x: {
                displayName: 'X',
                type: 'Integer',
                required: true
            },
            y: {
                displayName: 'Y',
                type: 'Integer',
                required: true
            }        }
    });

    mod.config(['$stateProvider',
        function($sp){
            var basePath = 'src/modules/circle/';
            var baseInstancePath = basePath + 'instance/';

            $sp.state('circle', {
                url: '/circles?page&limit',
                abstract: true,
                
                views: {
                     mainView: {
                        templateUrl: basePath + 'circle.tpl.html',
                        controller: 'circleCtrl'
                    }
                },
                resolve: {
                    model: 'circleModel',
                    circles: ['Restangular', 'model', '$stateParams', function (r, model, $params) {
                            return r.all(model.url).getList($params);
                        }]
                }
            });
            $sp.state('circleList', {
                url: '/list',
                parent: 'circle',
                views: {
                    circleView: {
                        templateUrl: basePath + 'list/circle.list.tpl.html',
                        controller: 'circleListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('circleNew', {
                url: '/new',
                parent: 'circle',
                views: {
                    circleView: {
                        templateUrl: basePath + 'new/circle.new.tpl.html',
                        controller: 'circleNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('circleInstance', {
                url: '/{circleId:int}',
                abstract: true,
                parent: 'circle',
                views: {
                    circleView: {
                        template: '<div ui-view="circleInstanceView"></div>'
                    }
                },
                resolve: {
                    circle: ['circles', '$stateParams', function (circles, $params) {
                            return circles.get($params.circleId);
                        }]
                }
            });
            $sp.state('circleDetail', {
                url: '/details',
                parent: 'circleInstance',
                views: {
                    circleInstanceView: {
                        templateUrl: baseInstancePath + 'detail/circle.detail.tpl.html',
                        controller: 'circleDetailCtrl'
                    }
                }
            });
            $sp.state('circleEdit', {
                url: '/edit',
                sticky: true,
                parent: 'circleInstance',
                views: {
                    circleInstanceView: {
                        templateUrl: baseInstancePath + 'edit/circle.edit.tpl.html',
                        controller: 'circleEditCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('circleDelete', {
                url: '/delete',
                parent: 'circleInstance',
                views: {
                    circleInstanceView: {
                        templateUrl: baseInstancePath + 'delete/circle.delete.tpl.html',
                        controller: 'circleDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
	}]);
})(window.angular);
