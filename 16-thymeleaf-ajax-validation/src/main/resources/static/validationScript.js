// validationScript.js
async function submitForm(event) {
    event.preventDefault(); // Stop the form's default behavior
    document.getElementById('getDataButton').click(); // Trigger a button click event
}

// event listener for the click event on the button with id 'getDataButton'
document.getElementById('getDataButton').addEventListener('click', async (e) => {
    try {
        // Retrieve data from the form with id 'homieForm' using the FormData object
        const formData = new FormData(document.getElementById('homieForm'));

        // Invoke the asynchronous fetch function to send data to the 'http://localhost:8080/validation' endpoint using the POST method
        const response = await fetch('http://localhost:8080/validation', {
            method: 'POST',
            body: formData
        });
        const data = await response.json();

        if (!response.ok && response.status === 400) {
            // If the response is a Bad Request (status 400), set the text in the respective divs

            document.getElementById('output').innerText = '';

            document.getElementById('homieNameResult').innerText = data.homieName !== undefined ? `Homie Name: ${data.homieName}` : '';
            document.getElementById('homieGangResult').innerText = data.homieGang !== undefined ? `Homie Gang: ${data.homieGang}` : '';

        } else if (response.ok) {
            // If the response is OK, set the text in the respective divs

            // Clear homieForm inputs
            document.getElementById('homieForm').reset();

            // Clear the responive divs that displayed validation errors
            document.getElementById('homieNameResult').innerHTML = '';
            document.getElementById('homieGangResult').innerHTML = '';

            // Put response OK text in responsive div
            document.getElementById('output').innerText = `${data.message}`

        }
    } catch (error) {

        document.getElementById('output').innerText = 'Unidentified error';
    }
});
