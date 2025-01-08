function validateForm() {
    var userName = document.getElementById("username").value;
    var pass = document.getElementById("password").value;
    var error = document.getElementById("errorMsg");

    error.textContent = "";

    if (userName == "") {
        error.textContent = "Tên đăng nhập không được để trống.";
        return false;
    }
    if (pass == ""){
        error.textContent = "Mật khẩu không được để trống.";
        return false;
    }

    if (pass.length < 8){
        error.textContent = "Mật khẩu không được dưới 6 kí tự.";
        return false;
    }

    return true;
}