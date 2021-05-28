/* ----------------------------------
  Animazione Scroll Orizzontale
------------------------------------*/

const slider = document.querySelector('.items'); //item selettore
let isDown = false;
let startX;
let scrollLeft;

/* MOUSEDOWN: Quando il pulsante sinistro del mouse è premuto fai... */
slider.addEventListener('mousedown', (event) => {
  isDown = true;
  slider.classList.add('active'); //aggiungi classe 'active' a .items
  startX = event.pageX - slider.offsetLeft; // event.pageX: coordinata orizzontale del puntatore del mouse
  scrollLeft = slider.scrollLeft; //scrollLeft: posizione left (in pixel) del lato sinistro dell'elemento
});

/* MOUSELEAVE: Quando il puntatore del mouse abbandona l'elemento selezionato fai... */
slider.addEventListener('mouseleave', () => {
  isDown = false;
  slider.classList.remove('active'); //rimuovi classe 'active' a .items
});

/* MOUSEUP: quando il bottone sinistro del mouse viene rilasciato fai... */
slider.addEventListener('mouseup', () => {
  isDown = false;
  slider.classList.remove('active'); //rimuovi classe 'active' a .items
});

/* MOUSEMOVE: quando il bottone sinistro del mouse è premuto ed il cursore si muove */
slider.addEventListener('mousemove', (event) => {
  if(!isDown) return; //esci se non hai attivato l'evento MOUSEDOWN
  event.preventDefault(); //interrompe l'azione predefinita di un elemento (slider che sarebbe .items)
  const x = event.pageX - slider.offsetLeft;
  const walk = (x - startX) * 2; //acceleriamo lo scroll di un fattore moltiplicativo
  slider.scrollLeft = scrollLeft - walk; //pixel scrollati all'interno dell'elemento selezionato
});
