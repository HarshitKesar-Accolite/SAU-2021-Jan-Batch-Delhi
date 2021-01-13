function validate(){
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var email = document.getElementById("email").value;
    var phnumber = document.getElementById("phnumber").value;
    var course = document.getElementById("course").value;
    var username = document.getElementById("username").value;
    var pwd = document.getElementById("pwd").value;
    var cpwd = document.getElementById("cpwd").value;
    var gender = document.getElementsByName("gender");
    if(fname.length < 3){
        alert("First name should be atleast 3 words !");
        return false;
    }
    if(lname.length < 3){
        alert("Last name should be atleast 3 words !");
        return false;
    }
    if(email.length < 1){
        alert("Email must be entered !");
        return false;
    }
    if(phnumber.length <= 0){
        alert("Phone number is required !");
        return false;
    }
    if(form_validation.gender[0].checked == false && form_validation.gender[1].checked == false){
        alert("Gender is Required !");
        return false;
    }
    if(form_validation.gender[0].checked){
        gender = "male";
    }
    else{
        gender = "female";
    }
    if(course == "select_course"){
        alert("Course is required !");
        return false;
    }
    if(username.length < 8){
        alert("Username must be of atleast 8 length !");
        return false;
    }
    if(username.length > 15){
        alert("Username can't be greater than 15 length !");
        return false;
    }
    if(pwd.length < 8){
        alert("Password must be of atleast 8 length !");
        return false;
    }
    if(pwd.length > 15){
        alert("Password can't be greater than 15 length !");
        return false;
    }
    if(pwd != cpwd){
        alert("Password and Confirm Password field must be matched !");
        return false;
    }

    var person = new Object();
    person.Name = fname + " " + lname;
    person.Email = email;
    person.PhoneNumber = phnumber;
    person.Course = course;
    person.Gender = gender;
    person.Password = pwd;
    person.ConfirmPassword = cpwd;

    console.log(person);
    
    // console.log(fname);
    // console.log(lname);
    // console.log(email);
    // console.log(phnumber);
    // console.log(gender);
    // console.log(course);
    // console.log(username);
    // console.log(pwd);
    // console.log(cpwd);
    return false;
}