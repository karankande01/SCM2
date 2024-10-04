
let currentTheme = getTheme();

//initial 
changeTheme();

function changeTheme() {
    // Set initial theme on the web page
    document.querySelector("html").classList.add(currentTheme);

    // Set the listener for the theme change button
    const changeThemeButton = document.querySelector("#theme_change_button");

    // Set the initial text of the button
    changeThemeButton.querySelector("span").textContent = currentTheme === "light" ? "Dark" : "Light";

    changeThemeButton.addEventListener("click", (event) => {

        // Remove the current theme from localStorage
        const oldTheme = currentTheme;

        // Toggle the theme
        if (currentTheme === "dark") {
            currentTheme = "light";
        } else {
            currentTheme = "dark";
        }

        // Update localStorage with the new theme
        setTheme(currentTheme);

        // Remove the old theme class and add the new theme class
        document.querySelector("html").classList.remove(oldTheme);
        document.querySelector("html").classList.add(currentTheme);

        // Update the button's text to reflect the new theme
        changeThemeButton.querySelector("span").textContent = currentTheme === "light" ? "Dark" : "Light";
    });
}


//set theme to localStorage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}

//get theme from localStorage
function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}