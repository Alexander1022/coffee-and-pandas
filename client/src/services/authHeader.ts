export default function authHeader() {
    const userToken = localStorage.getItem('token');
    let user = null;

   if (userToken) {
        user = JSON.parse(userToken);
   }

    if (user && user.accessToken) {
        return { Authorization: 'Bearer ' + user.accessToken };
    } else {
        return { Authorization: '' };
    }
}