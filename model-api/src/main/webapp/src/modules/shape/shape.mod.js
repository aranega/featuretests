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
    var mod = ng.module('shapeModule', ['ngCrud', 'ui.router']);

    mod.constant('shapeModel', {
        name: 'shape',
        displayName: 'Shape',
		url: 'shapes',
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
            var basePath = 'src/modules/shape/';
            var baseInstancePath = basePath + 'instance/';

            $sp.state('shape', {
                url: '/shapes?page&limit',
                abstract: true,
                
                views: {
                     mainView: {
                        templateUrl: basePath + 'shape.tpl.html',
                        controller: 'shapeCtrl'
                    }
                },
                resolve: {
                    model: 'shapeModel',
                    shapes: ['Restangular', 'model', '$stateParams', function (r, model, $params) {
                            return r.all(model.url).getList($params);
                        }]
                }
            });
            $sp.state('shapeList', {
                url: '/list',
                parent: 'shape',
                views: {
                    shapeView: {
                        templateUrl: basePath + 'list/shape.list.tpl.html',
                        controller: 'shapeListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('shapeNew', {
                url: '/new',
                parent: 'shape',
                views: {
                    shapeView: {
                        templateUrl: basePath + 'new/shape.new.tpl.html',
                        controller: 'shapeNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('shapeInstance', {
                url: '/{shapeId:int}',
                abstract: true,
                parent: 'shape',
                views: {
                    shapeView: {
                        template: '<div ui-view="shapeInstanceView"></div>'
                    }
                },
                resolve: {
                    shape: ['shapes', '$stateParams', function (shapes, $params) {
                            return shapes.get($params.shapeId);
                        }]
                }
            });
            $sp.state('shapeDetail', {
                url: '/details',
                parent: 'shapeInstance',
                views: {
                    shapeInstanceView: {
                        templateUrl: baseInstancePath + 'detail/shape.detail.tpl.html',
                        controller: 'shapeDetailCtrl'
                    }
                }
            });
            $sp.state('shapeEdit', {
                url: '/edit',
                sticky: true,
                parent: 'shapeInstance',
                views: {
                    shapeInstanceView: {
                        templateUrl: baseInstancePath + 'edit/shape.edit.tpl.html',
                        controller: 'shapeEditCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('shapeDelete', {
                url: '/delete',
                parent: 'shapeInstance',
                views: {
                    shapeInstanceView: {
                        templateUrl: baseInstancePath + 'delete/shape.delete.tpl.html',
                        controller: 'shapeDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
	}]);
})(window.angular);
