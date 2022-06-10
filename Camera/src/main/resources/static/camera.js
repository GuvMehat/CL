"use strict";

class camera{
    constructor(id,brand, type,mount){
    this.id = id;
    this.brand = brand;
    this.type = type;
    this.mount = mount;
}
}


function createCamera (id, brand, type,mount) {{
  fetch(`http://localhost:8080/camera/create`, {
    method: "post",
    headers: {
        "content-Type": "application/json",
      },
    body: JSON.stringify({
    "id": id,
    "type":type,
    "mount":mount,
    "brand":brand
    }),

  })
  .then((response) => { if (response.status == 201) { location.reload(); } console.log(response) })
  .catch((error) => console.log(error));
    console.log("added");
}}

CameraSubmit.onclick =() => createCamera(
    createId.value,
    createName.value,
    createType.value,
    createMount.value,
);

let readCamera =() => {
  fetch('http://localhost:8080/camera/read')
  .then((response) => {
    if (response.status !== 200) {
        console.error(`status: ${response.status}`);
        return;
    }
    response.json().then((data) => {
        console.log(response.status);
        console.table(data);
        addItem(data);
    });
}).catch((error) => console.error(`Request failed: ${error}`));
}
showAllCamerasButton.onclick =() => readCamera();

let updatecamera = () => {
  fetch("http://localhost:8080/camera/update/" + cameraId.value, {
    method: "PUT",
    body: JSON.stringify({
      id: cameraId.value,
      brand: cameraBrand.value,
      type: cameraType.value,
      mount: cameraMount.value,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((json) => {
      console.log(json);
      clearForm();
      printOutput(json, { json });
    })
    .catch((err) => console.error("Error please stop what you're doing"));
};

let deletecamera = () => {
  fetch("http://localhost:8080/camera/delete/" + cameraId.value, {
    method: `DELETE`,
  })
    .then((response) => {
      response.json();
      if(response.status == "204"){
        document.myform.output.value ="Successfull";
        document.myform.setAttribute("id", "done");
      } else{
        document.myform.output.value ="Failed";
      }
    })
    .then((json) => console.log(json))
    .catch((err) => console.error(`Stop! ${err}`));
};



