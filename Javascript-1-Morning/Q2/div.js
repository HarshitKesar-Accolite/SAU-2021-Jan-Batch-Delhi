function highlight_even(){
    reset();
    for(var i=2; i<=20; i=i+2){
        document.getElementById("div"+i).style.backgroundColor="#00B2EE";
    }
}
function highlight_multipleOfFive(){
    reset();
    for(var i=5; i<=20; i=i+5){
        document.getElementById("div"+i).style.backgroundColor="#dc143c";
    }
}
function reset(){
    for(var i=1; i<=20; i++){
        document.getElementById("div"+i).style.backgroundColor="white";
    }
}