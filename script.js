function toSignUpPage() {
    window.location.href = "signup.html";
}

function toSignInPage() {
    window.location.href = "signin.html";
}

function signUp() {
    console.log("Sign Up");
    signUpValidation();
    //create an account


    //display successful message

}

function signIn() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    console.log(email);
    console.log(password);

    window.location.href = "signup.html";
}

function search() {
    const pickupLocation = document.getElementById("pick-up-location").value;
    const destination = document.getElementById("destination").value;
    const pickupDate = document.getElementById("pick-up-date").value;
    const pickupTime = document.getElementById("pick-up-time").value;
    const seatsType = document.getElementById("seats-type").value;
    const children = document.getElementById("children-input").value;
    const adults = document.getElementById("adult-input").value;

    if (!pickupLocation || !destination || !pickupDate || !pickupTime || !seatsType || !children || !adults) {
        alert('Please fill out all fields before searching!');
        return;
    }   
    
    
}