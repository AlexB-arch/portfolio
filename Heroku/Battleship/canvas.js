onload = function draw() {
    const grid = document.getElementById('grid');
    var context = grid.getContext('2d');

    var dim = 40;

    context.beginPath();

    // Vertical Captions
    for (var y = 1; y <= 10; y++) {
        context.fillStyle = '#FF0000';
        context.font = 'bold 18px sans-serif';
        context.testBaseLine = 'bottom';
        context.fillText(y, 10, y * dim + 24);
    }
    // Horizontal Captions
    for (var x = 1; x <= 10; x++) {
        context.fillStyle = '#FF0000';
        context.font = 'bold 18px sans-serif';
        context.testBaseLine = 'bottom';
        context.fillText(x, x * dim + 14, 20);
    }

    for (var x = 1; x <= 10; x++) {
        for (var y = 1; y <= 10; y++) {
            context.rect(x * dim, y * dim, dim, dim);
            context.lineWidth = 2;
            context.strokeStyle = '#a0a0a0';
            context.stroke();
        }
    }

    function highlight_cell(context, x, y, dim) {
        context.beginPath();
        context.rect(x * dim + 1, y * dim + 1, dim - 2, dim - 2);
        context.fillStyle = '#84BDA6';
        context.fill();
    }
}
