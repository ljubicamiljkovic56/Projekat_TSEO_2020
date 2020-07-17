function login(){
	
	var usernameInput = $('#usernameInput');
	var passwordInput = $('#passwordInput');
	
	var username = usernameInput.val();
	var password = passwordInput.val();
	
	$.post("http://localhost:8080/api/login",
			
	{
		'username': username, 
		'password': password
	},
	function(response){
		console.log('login');
		console.log(response);
		alert('Uspesno ste se ulogovali');
		
		if(response == 'admin'){
			window.location.href = 'admin.html';
		}else {
			window.location.href = 'student_main.html';
		}
	}
	);
}