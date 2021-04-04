let getAllLords = async function () {
    return await fetch("Http://localhost:8070/lords", {
        methd: 'GET',
    })
        .then(r => r.json())
        .then(function (event) {
            const container = document.querySelector(".resultGetAllLords");
            const result = event.map(el => `<div>
                                                <p style="display: inline-block; margin: 0 10px 10px 0">name: ${el.name}</p>
                                                <p style="display: inline-block; margin: 0 10px 10px 0">age: ${el.age}</p>
                                                <ul>
                                                    ${el.planets.map(el => `<li>${el.name}</li>`).join("")}
                                                </ul>
                                            </div>`);

            container.innerHTML = result.join("");
            console.log(event);
        });
};

let getAllLoafers = async function () {
    return await fetch("Http://localhost:8070/loafers", {
        methd: 'GET',
    })
        .then(r => r.json())
        .then(function (event) {
            const container = document.querySelector(".resultGetAllLords");
            const result = event.map(el => `<div>
                                                <p style="display: inline-block; margin: 0 10px 10px 0">name: ${el.name}</p>
                                                <p style="display: inline-block; margin: 0 10px 10px 0">age: ${el.age}</p>
                                                <ul>
                                                    ${el.planets.map(el => `<li>${el.name}</li>`).join("")}
                                                </ul>
                                            </div>`);

            container.innerHTML = result.join("");
            console.log(event);
        });
};

let getTopLords = async function () {
    return await fetch("Http://localhost:8070/topLords", {
        methd: 'GET',
    })
        .then(r => r.json())
        .then(function (event) {
            const container = document.querySelector(".resultGetAllLords");
            const result = event.map(el => `<div>
                                                <p style="display: inline-block; margin: 0 10px 10px 0">name: ${el.name}</p>
                                                <p style="display: inline-block; margin: 0 10px 10px 0">age: ${el.age}</p>
                                                <ul>
                                                    ${el.planets.map(el => `<li>${el.name}</li>`).join("")}
                                                </ul>
                                            </div>`);

            container.innerHTML = result.join("");
            console.log(event);
        });
};

let getAllPlanet = async function () {
    return await fetch("Http://localhost:8070/planets", {
        methd: 'GET',
    })
        .then(r => r.json())
        .then(function (event) {
            const container = document.querySelector(".resultGetAllPlanets");
            const result = event.map(el => `<div>
                                                <p style="display: inline-block; margin: 0 10px 10px 0">id: ${el.id}</p>
                                                <p style="display: inline-block; margin: 0 10px 10px 0">name: ${el.name}</p>
                                            </div>`);

            container.innerHTML = result.join("");
            console.log(event);
        });
};





let formCreateLord = document.querySelector("form.createLord");
formCreateLord.addEventListener("submit", function (evt) {
    evt.preventDefault();
    let data = {
        name: this.elements.name.value,
        age: this.elements.age.value
    };

    fetch("Http://localhost:8070/lords", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(r => r.json())
        .then(r => {
            console.log(r);
            getAllLords();
        })
});

getAllLords();


let formCreatePlanet = document.querySelector("form.createPlanet");
formCreatePlanet.addEventListener("submit", function (evt) {
    evt.preventDefault();
    let data = {
        name: this.elements.name.value,
    };

    fetch("Http://localhost:8070/planets", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(r => r.json())
        .then(r => {
            console.log(r);
            getAllPlanet();
        })
});

getAllPlanet();

let formDestroyPlanet = document.querySelector("form.destroyPlanet");
formDestroyPlanet.addEventListener("submit", function (evt) {
    evt.preventDefault();

    fetch("Http://localhost:8070/planets/" + this.elements.id.value, {
        method: 'DELETE'
    })
        .then(r => r.text())
        .then(r => {
            console.log(r);
            getAllPlanet();
            getAllLords();
        })
});

let formManagerPlanet = document.querySelector("form.managerPlanet");
formManagerPlanet.addEventListener("submit", function (evt) {
    evt.preventDefault();

    fetch("Http://localhost:8070/lordPlanet/" + this.elements.idLord.value + "/" + this.elements.idPlanet.value, {
        method: 'PUT'
    })
        .then(r => r.text())
        .then(r => {
            console.log(r);
            getAllLords();
        })
});


let allLords = document.querySelector(".allLords");
allLords.addEventListener("click",  getAllLords);

let allLoafer = document.querySelector(".allLoafers");
allLoafer.addEventListener("click",  getAllLoafers);

let topLords = document.querySelector(".topLords");
topLords.addEventListener("click",  getTopLords);








let test = function () {
    formCreateLord.querySelector("button").click();
};

