/**
 *
 */

function syncPassword(sync) {
    document.forms[0].inputPassword.value = sync.value;
    document.forms[0].inputText.value = sync.value;
}

function toggleInputType(chk) {
    if (chk.checked) {
        document.forms[0].inputPassword.style.display = "inline-block";
        document.forms[0].inputText.style.display = "none";
    } else {
        document.forms[0].inputPassword.style.display = "none";
        document.forms[0].inputText.style.display = "inline-block";
    }

    // IEはフォーカスを外した時に適用される
    chk.blur();
}