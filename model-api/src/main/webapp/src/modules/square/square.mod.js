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
    var mod = ng.module('squareModule', ['ngCrud', 'ui.router']);

    mod.constant('squareModel', {
        name: 'square',
        displayName: 'Square',
		url: 'squares',
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
            var basePath = 'src/modules/square/';
            var baseInstancePath = basePath + 'instance/';

            $sp.state('square', {
                url: '/squares?page&limit',
                abstract: true,
                
                views: {
                     mainView: {
                        templateUrl: basePath + 'square.tpl.html',
                        controller: 'squareCtrl'
                    }
                },
                resolve: {
                    model: 'squareModel',
                    squares: ['Restangular', 'model', '$stateParams', function (r, model, $params) {
                            return r.all(model.url).getList($params);
                        }]
                }
            });
            $sp.state('squareList', {
                url: '/list',
                parent: 'square',
                views: {
                    squareView: {
                        templateUrl: basePath + 'list/square.list.tpl.html',
                        controller: 'squareListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('squareNew', {
                url: '/new',
                parent: 'square',
                views: {
                    squareView: {
                        templateUrl: basePath + 'new/square.new.tpl.html',
                        controller: 'squareNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('squareInstance', {
                url: '/{squareId:int}',
                abstract: true,
                parent: 'square',
                views: {
                    squareView: {
                        template: '<div ui-view="squareInstanceView"></div>'
                    }
                },
                resolve: {
                    square: ['squares', '$stateParams', function (squares, $params) {
                            return squares.get($params.squareId);
                        }]
                }
            });
            $sp.state('squareDetail', {
                url: '/details',
                parent: 'squareInstance',
                views: {
                    squareInstanceView: {
                        templateUrl: baseInstancePath + 'detail/square.detail.tpl.html',
                        controller: 'squareDetailCtrl'
                    }
                }
            });
            $sp.state('squareEdit', {
                url: '/edit',
                sticky: true,
                parent: 'squareInstance',
                views: {
                    squareInstanceView: {
                        templateUrl: baseInstancePath + 'edit/square.edit.tpl.html',
                        controller: 'squareEditCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('squareDelete', {
                url: '/delete',
                parent: 'squareInstance',
                views: {
                    squareInstanceView: {
                        templateUrl: baseInstancePath + 'delete/square.delete.tpl.html',
                        controller: 'squareDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
	}]);
})(window.angular);
