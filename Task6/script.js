const data = JSON.parse(localStorage.getItem("EmployeeDetails")) || [];

function renderTable() {
    const tableBody = document.getElementById('row');
    const messageElement = document.querySelector('.message');
    const rows = data.map((employee, index) => `
        <tr>
            <td>${index + 1}</td>    
            <td>${employee.name}</td>    
            <td>${employee.email}</td>    
            <td>${employee.mobile}</td>    
            <td>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#update${index}" onclick="show(${index})">
                    Edit
                </button>
                <button type="button" class="btn btn-primary" onclick="deleteRow(${index})">Delete</button>
            </td>        
        </tr>
    `);

    tableBody.innerHTML = rows.join('');

    messageElement.style.display = data.length === 0 ? 'contents' : 'none';
}

function resetFormFields(...ids) {
    ids.forEach(id => (document.getElementById(id).value = ''));
}

function addRow() {
    const name = document.getElementById('ename').value;
    const email = document.getElementById('eemail').value;
    const mobile = document.getElementById('emobile').value;

    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const mobileRegex = /^\+?[0-9\s-]{10}$/;

    if (!name) {
        alert('Name must not be empty');
    } else if (!emailRegex.test(email)) {
        alert('Email is not in the correct format');
    } else if (!mobileRegex.test(mobile)) {
        alert('Phone number is not in the right format');
    } else {
        data.push({ name, email, mobile });
        localStorage.setItem('EmployeeDetails', JSON.stringify(data));
        resetFormFields('ename', 'eemail', 'emobile');
        renderTable();
    }
}

function deleteRow(index) {
    data.splice(index, 1);
    localStorage.setItem('EmployeeDetails', JSON.stringify(data));
    renderTable();
}

function updateRow(index) {
    const employee = data[index];
    employee.name = document.getElementById(`uename${index}`).value;
    employee.email = document.getElementById(`ueemail${index}`).value;
    employee.mobile = document.getElementById(`uemobile${index}`).value;
    
    localStorage.setItem('EmployeeDetails', JSON.stringify(data));
    renderTable();
}

function show(index) {
    const employee = data[index];
    document.getElementById(`uename${index}`).value = employee.name;
    document.getElementById(`ueemail${index}`).value = employee.email;
    document.getElementById(`uemobile${index}`).value = employee.mobile;
}

// Initial rendering
renderTable();
