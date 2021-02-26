<script type='text/javascript'>

function rafraichir() {

TestDWR.getMedicament(afficherMedicaments, $("medicament").value);
}

function afficherPersonne(data) {

DWRUtil.setValue("nomPersonne",data.prix_vente);


}

function init() {

DWRUtil.useLoadingMessage();

}

</script>