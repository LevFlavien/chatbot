var chat = angular.module('Chat', ['CHATBOT', 'ngResource']);

/* Controllers des bases*/
chat.controller('afficherChat', function ($scope, $rootScope, $location, chatFactory) {

    $scope.messages = chatFactory.getConversation({
        id: "59cb79967ef2a5399410f736"
    })
})


/* Factories */
chat.factory('chatFactory', function ($resource) {
    return $resource('./rest/messages:methodeRest/:id', {
        methodeRest: '@methodeRest',
        id: '@id'
    }, {
        getConversation:
        {
            method: 'GET',
            params: { id: '@id'},
            isArray: true,
        }
    })
})