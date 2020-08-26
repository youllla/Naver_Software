function addressVal() {
	var address = document.getElementById("address");

	address.options[address.selectedIndex].val;
	console.log($(address).val());
}

function radio() {
	$("input[name=genderVal]:checked").each(function() {
	  var test = $(this).val(); 
	  alert("벨류값확인 : " + test);
	}
}