document.addEventListener('DOMContentLoaded', function() {
    // Function to change name color based on hair color
    function changeNameColour() {
        var students = document.querySelectorAll("#students > div"); // Selecting each student's div
        students.forEach(function(studentDiv) {
            var studentName = studentDiv.querySelector("#name"); // Finding the name element within each student's div
            var studentHairColour = studentDiv.querySelector("#haircolour"); // Finding the haircolour element within each student's div
            studentName.style.color = studentHairColour.innerText.toLowerCase().trim();
        });
    }

    function changeWidth() {
        var students = document.querySelectorAll("#students > div"); 
        students.forEach(function(studentDiv) {
            var studentWeight = studentDiv.querySelector("#weight"); 
            var weight = parseInt(studentWeight.textContent.trim()); 
            var weightFactor = 2 * weight;
            studentDiv.style.width = weightFactor + "px";
        });
    }

    function changeHeight() {
        var students = document.querySelectorAll("#students > div"); 
        students.forEach(function(studentDiv) {
            var studentHeight = studentDiv.querySelector("#height"); 
            var height = parseInt(studentHeight.textContent.trim()); 
            var heightFactor = 0.75 * height;
            studentDiv.style.height = heightFactor + "px";
        });
    }

    function changeBoxColour() {
        var students = document.querySelectorAll("#students > div"); 
        students.forEach(function(studentDiv) {
            var studentBorder = studentDiv.style.border;
            var studentFavColour = studentDiv.querySelector("#favcolour").innerText.toLowerCase().trim(); 
            studentDiv.style.border = "2px solid " + studentFavColour;
        });
    }

    changeNameColour(); // Call the function to change name colors
    changeWidth(); // call the function to change the width
    changeHeight(); // call the function to change the height
    changeBoxColour(); // call the function to change the colour of the surrounding box

    var newStudentButton = document.getElementById("addnewstudent")
    newStudentButton.addEventListener('click', function(){
        window.location.href = '/add.html'
    });

    var deleteStudentButton = document.getElementById("deletestudent")
    deleteStudentButton.addEventListener('click', function(){
        window.location.href = '/delete.html'
    });

    var editStudentButton = document.getElementById("editstudent")
    editStudentButton.addEventListener('click', function(){
        window.location.href = '/studentToEdit.html'
    });

 
    
});
