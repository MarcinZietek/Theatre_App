
function checkPasswordMatch(){
    let password = document.getElementById('password').value;
    let confirmPassword = document.getElementById('confirmPassword').value;

    if (password != confirmPassword){
        document.getElementById('wrong_password').style.color = 'red';
        document.getElementById('wrong_password').innerHTML = 'Hasła do siebie nie pasują!';
        document.getElementById('create').disabled = true;
    }else{
        document.getElementById('wrong_password').style.color = 'green';
        document.getElementById('wrong_password').innerHTML = 'Hasła są zgodne';
        document.getElementById('create').disabled = false;
    }
}
