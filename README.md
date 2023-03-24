<img src="https://raw.githubusercontent.com/Alexander1022/coffee-and-pandas/main/client/src/assets/logo.ico" align="right" width="50" height="50"/>

# Entertizer - Find fun, anytime, anywhere


Entertizer is a web application that allows users to connect with each other and find entertainment venues nearby. 
The app is built using React, TypeScript, TailwindCSS on the client-side, and SpringBoot, Java on the server-side, with MySQL as the database.

## Installation
To install and run Entertizer on your local machine, please follow the steps below:

- Clone the repository from GitHub:
````bash
git clone https://github.com/{username}/{repository-name}.git
````
- Navigate to the project directory:
````bash
cd {repository-name}
````
- Install the necessary dependencies:
````
npm install
````
- Start the server (SQL):
````
npm start
````
- Open a browser and navigate to http://localhost:3000/


## Features

Entertizer has the following features:

- Adding Friends
Users can add friends by clicking on the "Add Friends" button and entering the username of the friend they want to add.

- Map with Leaflet
Entertizer uses the Leaflet library to display a map of the user's current location. The map shows different types of entertainment venues, such as clubs, bars, discos, malls, erotic clubs, and restaurants.

- Creating Events
Users can create events by clicking on a venue on the map and then clicking the "Create Event" button. They can specify the date, type of event, and invite friends to the event.

## Technology Stack

Entertizer is built using the following technology stack:

#### Client
  1. React 
  2. TypeScript
  3. TailwindCSS
#### Server
  1. SpringBoot
  2. Java
#### Database
  1. MySQL

## Routes

URLs | Description
---------|---------
 */* | Index page - page where guest user can see a description of the app.
 */home* | Home page - page where authorised user can see a map of the nearby places, friends list, search bar, and recent events
 */users/register* | Register page - page where user can register.
 */users/login* | Login page - page where user can login.
 */users/add/friends* | Page you get directed to when adding a new friend.
 */users/friend_requests* | Page where the user can see all the friend requests they have.
 */users/friends/delete* | Page you get directed to when removing a friend.
 */users/friends/view/accepted* | My friends page - page where you can see all you friends.
 */places/addrating* | Rating a place page - page where you can leave a rating on a place from 1 to 5 stars
 */places/addreview* | Reviewing a place page - page where you can leave a comment on a chosen location
 */events/add* | Adding a new event on a chosen location
 */events/delete* | Deleting an event created by the current user
 */events/inviteFriends* | Inviting friends to an event created by the current user
 */events/myevents* | View page for the events created by the current user
 */events/update* | Editing an event created by the current user


Database diagram screenshot
---

 ![databasе](https://github.com/Alexander1022/coffee-and-pandas/blob/main/docs/database/db_diagram.png)


Website screenshots
---


## Contributing
If you would like to contribute to Entertizer, please fork the repository and create a pull request with your changes. We welcome all contributions and appreciate your help in improving the app.

## License
Entertizer is licensed under the MIT License. See LICENSE.md for more information.
