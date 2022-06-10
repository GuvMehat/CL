"use strict";

class lens{
    constructor(id,brand, fstop,mount,range){
    this.id = id;
    this.brand = brand;
    this.fstop = fstop;
    this.range=range;
    this.mount = mount;
}
}


function createLens (id,brand, fstop,mount,range) {{
  fetch(`http://localhost:8080/lens/create`, {
    method: "post",
    headers: {
        "content-Type": "application/json",
      },
    body: JSON.stringify({
        "id": id,
        "brand": brand,
        "fstop": fstop,
        "range":range,
        "mount": mount
  })
  })
  .then((response) => { if (response.status == 201) { location.reload(); } console.log(response) })
  .catch((error) => console.log(error))
}}

LensSubmit.onclick =() => lensCamera(
    createId.value,
    LensBrand.value,
    LensFstop.value,
    LensMount.value,
    LensRange.value
);

let readLens =() => {
  fetch('http://localhost:8080/lens/read')
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
showAllLensButton.onclick =() => readLens();

let updatlens = () => {
  fetch('http://localhost:8080/lens/update/' + createId.value, {
    method: "PUT",
    body: JSON.stringify({
      "id":  createId.value,
      "brand": LensBrand.value,
      "fstop": LensFstop.value,
      "mount": LensMount.value,
      "range": LensRange.value
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

updateLensButton.onclick =() => createLens(
    createId.value,
    LensBrand.value,
    LensFstop.value,
    LensMount.value,
    LensRange.value
);

let deletelens = () => {


  fetch("http://localhost:8080/lens/delete/" + cameraId.value, {
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
deleteLensButton.onclick=() => deletecamera();

