var myApp = angular.module('CHATBOT', ['Chat', 'ngResource']);
var my = '.'

// TODO page de recherche 
/** Configuration des routes de l'application*/
myApp.config(function ($routeProvider, $httpProvider) {

    // Ajout de l'intercepteur HTTP
    // $httpProvider.responseInterceptors.push('IntercepteurHTTP');

    /** Accueil */
    $routeProvider.when('/', {
        templateUrl: my + '/partials/chat.html',
        controller: 'afficherChat',
        pageKey: 'HOME'

    /** Sinon */
    }).otherwise({
        redirectTo: '/'
    });
});


/** Controller. */
myApp.controller('ChatCtrl', function ($route, $scope, $rootScope, $location) {

})


/** Intercepteur HTTP => Autentification. */
/*myApp.factory('IntercepteurHTTP', function ($rootScope, $q, $location) {
    return function (promise) {
        return promise.then(function (response) {
            // surveillance de la reponse
            $rootScope.reponse = response;
            // ne rien faire si il n'a pas d'erreur
            return response;
        }, function (response) {
            // fonction qui sera executee si Angular recoit une erreur http
            // on teste si c'est une erreur 401.
            if (response.status === 401) {
                // l'utilisateur sera redirige vers la page accueil
                $location.path('/');
            }
            // surveillance de la reponse
            $rootScope.reponse = response;
            return $q.reject(response);
        });
    };
});*/