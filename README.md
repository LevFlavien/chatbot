# CHATBOT - backFacebookAPI
Projet Webservices - Bot de conversation instantanée.

<p><p><B>GROUPE :</B>
<p>- Flavien LEVESQUE</p>
<p>- Romain ETIENNE</p>
<p>- Adrien EXCOFFIER</p>
<p>- Alex MEDINA</p>
<p>- Amandine BUCAS</p>
</p></p>

<p><p><B>DATE DE RENDU :</B>
25/10/17</p></p>

<p><p><B>ORAL :</B> 
13h / 20min soutenance (ce qu'on a fait, comment, la stack, objectif du bot) - 10 min de questions</p></p>

<p><p><B>ELEMENTS DEMANDES :</B>
<p> - <B>ChatBot Messenger</B>
	      <p> utiliser les web hooks (notification)
<p> - <B>API messenger</B>
	      <p> langage au choix
	      <p> service pour chatbot (back) / TU
	      <p> front : voir les messages publiés par les utilisateurs (stockage en base)
	      <p> doc d'API
<p> - <B>Monitoring</B> (connaître l'état de l'appli)
<p> - <B>Alerting</B> (notification crash)</p></p>

# Utilisation

### Base de données

<p>Veillez à avoir une base mongoDB en fonction pour utiliser l'application. La version utilisée est 3.4.9
La database utilisée est "chatbot", elle sera crée automatiquement.</p>

<p>2 collections sont disponibles : 
- <B>Users</B>
![Users](https://github.com/LevFlavien/chatbot/blob/master/images/users.png)

- <B>Messages</B>
![Messages](https://github.com/LevFlavien/chatbot/blob/master/images/messages.png) </p>

<p>Pour ajouter du contenu dans "users", vous pouvez utiliser la commande :
```
curl -X "POST" "http://localhost:8088/rest/users/add?id=1&nom=medina&prenom=alex" </p>
```
<p>et dans "messages"
```
curl -X "POST" "http://localhost:8088/rest/messages/add?id=1&contenu=votre%20message&expediteur=false" </p>
```
