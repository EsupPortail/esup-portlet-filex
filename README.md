Portlet d'accroche pour FileX - https://github.com/EsupPortail/filex
============================

esup-portlet-filex est une portlet JSR286 qui fonctionne avec la version FileX ESUP disponible sur github :
https://github.com/EsupPortail/filex

Testé avec la version 1.8, elle ne fonctionne actuellement qu'avec un FileX configuré pour utiliser l'authentification Shibboleth.
La compatibilité avec les autres modes d'authentification demanderait quelques modifications : n'hésitez pas à nous les proposer via des Pull Request !

### Fonctionnement et mise en place

esup-portlet-filex s'appuie sur le rendu XML proposé par FileX via l'url /filex/esup

Les paramétrages Apache de FileX sur /filex/esup doivent permettre à la portlet de requêter cette url en passant en entête HTTP l'EduPersonPrincipalName "eppn" en lieu et place du mod_shib 
(qui ne doit donc pas être en place sur cette url donnée à esup-portlet-filex).

Ainsi, lors de la publication de la portlet : 
* restUrl correspond à cette url /filex/esup qui sera sans doute une url "interne" à votre plateforme accessible uniquement depuis vos ENT
* serviceUrl est l'url d'entrée du filex qui pourra être présentée aux utilisateurs.

### Screenshots
http://www.esup-portail.org/display/EsupPortletFileX/EsupPortletFileX#EsupPortletFileX-Copiesd%27%C3%A9cran

